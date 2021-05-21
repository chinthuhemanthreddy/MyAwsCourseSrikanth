package com.organization.university.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.organization.university.custom.exception.CustomException;
import com.organization.university.dto.ASPAccountInfo;
import com.organization.university.dto.ASPAccountInfoAndVehicleInfo;
import com.organization.university.dto.ASPParamInfo;
import com.organization.university.dto.ASPVehicleInfo;
import com.organization.university.dto.GroudingDetails;
import com.organization.university.helper.RestHelper;
import com.organization.university.model.ASPParamPayload;
import com.organization.university.model.AccountDetailsByKeyPayload;
import com.organization.university.model.AccountDetailsByKeyResponse;
import com.organization.university.model.AccountInformationDetailsByKey;
import com.organization.university.model.ActivityContext;
import com.organization.university.model.BorrowerInformationDetailsByKey;
import com.organization.university.model.Collateral;
import com.organization.university.model.GetAccountDetailsByKeyRequest;
import com.organization.university.model.TenantContext;
import com.organization.university.repository.GetAccountDetailsByKeyRepository;
import com.organization.university.repository.GetReasonForReturnByTenantIdRepository;
import com.organization.university.repository.GetVehicleInformationByKeyRepository;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountDetailsByKeyService {
	
	@Setter
	@Value("${getaccountdetailsbykey_service_dev}")
	private String getaccountdetailsbykey_service_dev;
	@Setter
	@Value("${test_client_id}")
	private String test_client_id;
	@Setter
	@Value("${test_env_tye}")
	private String test_env_tye;
	@Setter
	@Value("${test_consumer_id}")
	private String test_consumer_id;
	@Setter
	@Value("${test_tenant_id}")
	private String test_tenant_id;
	@Setter
	@Value("${test_activity_id}")
	private String test_activity_id;
	@Setter
	@Value("${test_user_id}")
	private String test_user_id;

	@Autowired
	private final GetAccountDetailsByKeyRepository getAccountDetailsByKeyRepository;

	@Autowired
	private final GetVehicleInformationByKeyRepository getVehicleInformationByKeyRepository;

	@Autowired
	private final GetReasonForReturnByTenantIdRepository getReasonForReturnByTenantIdRepository;
	
	@Autowired
	private final RestHelper restHelper;
	

	@Transactional
	public ASPAccountInfoAndVehicleInfo getAccountDetailsByKeyResponse(AccountDetailsByKeyPayload payload,
			String authorization) {

		ASPAccountInfoAndVehicleInfo aSPAccountInfoAndVehicleInfo = new ASPAccountInfoAndVehicleInfo();
		try {
			log.info("Entering into getAccountDetailsByKeyResponse method in Service :::: ");
			TenantContext tenantContext = new TenantContext();
			tenantContext.setClientId(test_client_id);
			tenantContext.setConsumerEnvironmentId(test_env_tye);
			tenantContext.setConsumerSystemId(test_consumer_id);
			tenantContext.setTenantId(test_tenant_id);
			ActivityContext activityContext = new ActivityContext();
			activityContext.setActivityId(test_activity_id);
			activityContext.setUserId(test_user_id);
			GetAccountDetailsByKeyRequest request = new GetAccountDetailsByKeyRequest();
			request.setLookupKey(payload.getLookupKey());
			request.setLookupValue(payload.getLookupValue());
			request.setReturnLimit(100);
			request.setTenantContext(tenantContext);
			request.setActivityContext(activityContext);

			//Calling helper to get reponse from getAccountDetailsByKey Service
			AccountDetailsByKeyResponse  accResponse= restHelper.restForGetAccountDetailsbyKey(request,getaccountdetailsbykey_service_dev, authorization);

			log.info("getting accResponse :::: " + accResponse.toString());

			// Storing into ASP DB
			// Integer i = getAccountDetailsByKeyRepository.insertAccountInfo();
			// System.out.println("data inserted or not :::: "+i);

			// Storing into ASP DB
			if (accResponse.getAccountInformation() != null && accResponse.getAccountInformation().size() > 0) {
				BorrowerInformationDetailsByKey borrowerInformationDetailsByKeyresponse = null;
				Collateral collateralresponse = null;
				AccountInformationDetailsByKey accountInformationDetailsBykeyResponse = accResponse
						.getAccountInformation().get(0);
				if (accountInformationDetailsBykeyResponse.getBorrowerInformation() != null
						&& accountInformationDetailsBykeyResponse.getBorrowerInformation().size() > 0) {
					borrowerInformationDetailsByKeyresponse = accountInformationDetailsBykeyResponse
							.getBorrowerInformation().get(0);
				}
				if (accountInformationDetailsBykeyResponse.getCollateral() != null
						&& accountInformationDetailsBykeyResponse.getCollateral().size() > 0) {
					collateralresponse = accountInformationDetailsBykeyResponse.getCollateral().get(0);
				}
				log.info("befre checking aSPVehicleInfo...");

				List<ASPVehicleInfo> aSPVehicleInfo = getVehicleInformationByKeyRepository
						.findByAccount(collateralresponse.getVin());
				System.out.println("befre checking aSPVehicleInfo...+aSPVehicleInfo");
				// Model year is inserting as a 12345 as per the requirement
				if (aSPVehicleInfo.size() > 0) {
					log.info("record is present, so updating the record. ");
					Integer vehicleudateRecordStatus = getVehicleInformationByKeyRepository.updateVehicleInfo(
							collateralresponse.getVin(), collateralresponse.getMake(), collateralresponse.getModel(),
							"12345", collateralresponse.getYear(), "Color", test_tenant_id);
					System.out.println("updating status ::: " + vehicleudateRecordStatus);
				} else {
					log.info("record is not present, so insertig the record. ");
					Integer vehicleRecordStatus = getVehicleInformationByKeyRepository.insertVehicleInfo(
							collateralresponse.getVin(), collateralresponse.getMake(), collateralresponse.getModel(),
							"12345", collateralresponse.getYear(), "Color", test_tenant_id);
					log.info("inserting status ::: " + vehicleRecordStatus);
				}

				log.info("befre checking aSPAccountInfo...");
				List<ASPAccountInfo> aSPAccountInfo = getAccountDetailsByKeyRepository.findByAccountNumberAndVin(
						accountInformationDetailsBykeyResponse.getAccountNumber(), collateralresponse.getVin());
				log.info("after checking aSPAccountInfo..." + aSPAccountInfo);
				LocalDateTime ldt_mt_date = null;
				String maturityDate = accountInformationDetailsBykeyResponse.getMaturityDate();
				String maturityDate_replace = maturityDate.replace(" ", "T");
				ldt_mt_date = LocalDateTime.parse(maturityDate_replace);
				if (aSPAccountInfo.size() > 0) {

					log.info("ldt_mt_date udate::: " + ldt_mt_date);
					Integer i = getAccountDetailsByKeyRepository.updateAccountInfo(
							accountInformationDetailsBykeyResponse.getAccountNumber(), // account number
							collateralresponse.getVin(), // VIN
							LocalDateTime.now(), // today's date
							accountInformationDetailsBykeyResponse.getProduct(), // product -- accounttype
							borrowerInformationDetailsByKeyresponse.getBorrowerType(), // BorrowerType
							borrowerInformationDetailsByKeyresponse.getFirstName()
									+ borrowerInformationDetailsByKeyresponse.getLastName(), // Lease Name
							accountInformationDetailsBykeyResponse.getRepossessionStatus(), // RepossessionStatus
							borrowerInformationDetailsByKeyresponse.getBankruptcyCode(), // BankruptcyCode
							ldt_mt_date, // MaturityDate
							(int) accountInformationDetailsBykeyResponse.getTotalPaymentAmountRemaining(), // reamining
							// payment
							(int) accountInformationDetailsBykeyResponse.getNetPayoffAmount() // pay_off_amt
					);
					log.info("updating status updateAccountInfo::: " + i);
				} else {
					log.info("ldt_mt_date insert ::: " + ldt_mt_date);
					log.info("accountInformationDetailsBykeyResponse.getAccountNumber() :: "
							+ accountInformationDetailsBykeyResponse.getAccountNumber());
					log.info("collateralresponse.getVin() :: " + collateralresponse.getVin());
					log.info("LocalDateTime.now() ::: " + LocalDateTime.now());
					log.info(" accountInformationDetailsBykeyResponse.getProduc :: "
							+ accountInformationDetailsBykeyResponse.getProduct());
					log.info("  borrowerInformationDetailsByKeyresponse.getBorrowerType() :: "
							+ borrowerInformationDetailsByKeyresponse.getBorrowerType());
					log.info(
							"  borrowerInformationDetailsByKeyresponse.getFirstName() + borrowerInformationDetailsByKeyresponse.getLastName() :: "
									+ borrowerInformationDetailsByKeyresponse.getFirstName()
									+ borrowerInformationDetailsByKeyresponse.getLastName());
					log.info("  accountInformationDetailsBykeyResponse.getRepossessionStatus():: "
							+ accountInformationDetailsBykeyResponse.getRepossessionStatus());
					log.info(" borrowerInformationDetailsByKeyresponse.getBankruptcyCode( :: "
							+ borrowerInformationDetailsByKeyresponse.getBankruptcyCode());
					log.info("remaining amount :: "
							+ (int) accountInformationDetailsBykeyResponse.getTotalPaymentAmountRemaining());
					log.info("payoff amount ::: " + (int) accountInformationDetailsBykeyResponse.getNetPayoffAmount());

					Integer i = getAccountDetailsByKeyRepository.insertAccountInfo(
							accountInformationDetailsBykeyResponse.getAccountNumber(), // account number
							collateralresponse.getVin(), // VIN
							LocalDateTime.now(), // today's date
							accountInformationDetailsBykeyResponse.getProduct(), // product -- accounttype
							borrowerInformationDetailsByKeyresponse.getBorrowerType(), // BorrowerType
							borrowerInformationDetailsByKeyresponse.getFirstName()
									+ borrowerInformationDetailsByKeyresponse.getLastName(), // Lease Name
							accountInformationDetailsBykeyResponse.getRepossessionStatus(), // RepossessionStatus
							borrowerInformationDetailsByKeyresponse.getBankruptcyCode(), // BankruptcyCode
							ldt_mt_date, // MaturityDate
							(int) accountInformationDetailsBykeyResponse.getTotalPaymentAmountRemaining(), // reamining
							// payment
							(int) accountInformationDetailsBykeyResponse.getNetPayoffAmount() // pay_off_amt
					);
					log.info("data inserted or not insertAccountInfo :::: " + i);

				}
				List<ASPAccountInfo> aSPAccountInfores = getAccountDetailsByKeyRepository
						.findByAccountNumberAndVin(accountInformationDetailsBykeyResponse.getAccountNumber(),
								collateralresponse.getVin());
				List<ASPVehicleInfo> aSPVehicleInfores = getVehicleInformationByKeyRepository
						.findByAccount(collateralresponse.getVin());
				aSPAccountInfoAndVehicleInfo.setAccountInfo(aSPAccountInfores);
				aSPAccountInfoAndVehicleInfo.setVehicleInfo(aSPVehicleInfores);
			} else {
				log.info("not contains the account information...");
			}

		} catch (Exception ex) {
			log.error("exception in execute getAccountDetailsByKeyResponse ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return aSPAccountInfoAndVehicleInfo;
	}

	public List<ASPParamInfo> getReasonForReturn(ASPParamPayload payload, String authorization) {
		log.info("entering into getReason for return service method:::");
		List<ASPParamInfo> aspParamInfo;
		try {

			aspParamInfo = getReasonForReturnByTenantIdRepository.findByTenant(payload.getTenantId(),
					payload.getParamName());
			log.info("leaving  getReason for return service method:::");

		} catch (Exception ex) {
			log.error("exception in execute getReasonForReturn ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return aspParamInfo;

	}


	public List<GroudingDetails> getGroundingDetails(String dealerNumber) {
		List<GroudingDetails> groundDetails = null;
		try {
		log.info(" entering into getGroundingDetails in service class ");
		if(isValid(dealerNumber)){
		if(dealerNumber.contentEquals("ALL")){
			groundDetails = getAccountDetailsByKeyRepository.getAllGroundingDetails(dealerNumber);
		}else{
			groundDetails = getAccountDetailsByKeyRepository.getGroundingDetails(dealerNumber);
		}
		log.info("leaving  getGroundingDetails for return service method:::"+groundDetails);
		groundDetails = groundDetails.stream().filter((groundDetail) -> groundDetail.getDealer_action() == null).collect(Collectors.toList());
		}
		}
		catch(Exception ex) {
			log.error("exception in execute getReasonForReturn ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return groundDetails;
	}

	private boolean isValid(String dealerNumber){
		Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
		if (dealerNumber == null) {
			return false; 
		} 
		
		return (dealerNumber.length() == 10 && pattern.matcher(dealerNumber).matches()) || dealerNumber.contentEquals("ALL");
	}

	public boolean updateDealerAction(String dealerAction, String vin) {
		try {
			log.info(" entering into updateDealerAction in service class ");
			if(dealerAction.contentEquals("PassedVehicles") || dealerAction.contentEquals("PurchasedVehicles")){
				getAccountDetailsByKeyRepository.updateDealerAction(dealerAction, vin);
			}else{
				return false;
			}
			log.info("leaving  updateDealerAction for return service method:::");
			}
			catch(Exception ex) {
				log.error("exception in execute getReasonForReturn ::: " + ex.getMessage());
				throw new CustomException(
						"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return true;
	}

}