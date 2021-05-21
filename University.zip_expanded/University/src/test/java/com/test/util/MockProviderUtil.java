package com.test.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.ParseException;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import com.organization.university.contoller.GetGroundingDetailsController;
import com.organization.university.dto.ASPAccountInfoAndVehicleInfo;
import com.organization.university.dto.ASPParamInfo;
import com.organization.university.dto.ASPVehicleInfo;
import com.organization.university.dto.GroudingDetails;
import com.organization.university.helper.RestHelper;
import com.organization.university.model.AccountDetailsByKeyResponse;
import com.organization.university.model.AccountExtension;
import com.organization.university.model.AccountInformationDetailsByKey;
import com.organization.university.model.AccountInformationReponse;
import com.organization.university.model.BorrowerInformationDetailsByKey;
import com.organization.university.model.Collateral;
import com.organization.university.model.GetAccountDetailsByKeyRequest;
import com.organization.university.repository.GetAccountDetailsByKeyRepository;
import com.organization.university.repository.GetGroundingDetailsRepository;
import com.organization.university.repository.GetReasonForReturnByTenantIdRepository;
import com.organization.university.repository.GetVehicleInformationByKeyRepository;
import com.organization.university.service.AccountDetailsByKeyService;
import com.organization.university.service.DefiService;
import com.organization.university.service.GetGroundingDetailsService;

public class MockProviderUtil {

	public static DefiService getDefiService() {
		DefiService def = Mockito.mock(DefiService.class);
		Mockito.when(def.getTokenData()).thenReturn("Test");
		AccountInformationReponse sr = new AccountInformationReponse();
		sr.setActivityId("activity");
		Mockito.when(def.getAccountDetails(ArgumentMatchers.any(),ArgumentMatchers.anyString()))
		.thenReturn(sr);
		return def;
	}
	
	public static AccountDetailsByKeyService getAccountDetailsByKey() throws ParseException, IOException {
		AccountDetailsByKeyService accountDetailsByKeyService = Mockito.mock(AccountDetailsByKeyService.class);
		ASPAccountInfoAndVehicleInfo aSPAccountInfoAndVehicleInfo = new ASPAccountInfoAndVehicleInfo();
		ASPParamInfo aspInfo = new ASPParamInfo();
		aspInfo.setParamName("param name");
		aspInfo.setParamValue("param value");
		aspInfo.setTenantId("ljfldsjsdlfsjlf");
		aspInfo.setParamDescription("param description");
		List<ASPParamInfo> paramList = new ArrayList<>();
		paramList.add(aspInfo);
		GroudingDetails groundDetails = new GroudingDetails();
		groundDetails.setAccount_type("Savings type");
		groundDetails.setBrand("toyata");
		List<GroudingDetails> groundingList = new ArrayList<>();
		groundingList.add(groundDetails);
		Boolean isUpdated = true;
		Mockito.when(accountDetailsByKeyService.getAccountDetailsByKeyResponse(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(aSPAccountInfoAndVehicleInfo);
		Mockito.when(accountDetailsByKeyService.getReasonForReturn(ArgumentMatchers.any(), ArgumentMatchers.anyString())).thenReturn(paramList);
		Mockito.when(accountDetailsByKeyService.getGroundingDetails(ArgumentMatchers.anyString())).thenReturn(groundingList);
		Mockito.when(accountDetailsByKeyService.updateDealerAction(ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(isUpdated);
		
		return accountDetailsByKeyService;
	}
	
	public static GetAccountDetailsByKeyRepository getAccountDetailsByKeyRepository(){
			GetAccountDetailsByKeyRepository getAccountDetailsByKeyRepository = Mockito.mock(GetAccountDetailsByKeyRepository.class);
		
	GroudingDetails groudingDetails= new GroudingDetails();
			groudingDetails.setAccount_type("LEASE");
			groudingDetails.setBrand("TOYATA");
			groudingDetails.setExt_color("Color");
			groudingDetails.setModel("2015");
			List<GroudingDetails> listGroundDetails = new ArrayList<>();
			listGroundDetails.add(groudingDetails);
			
			Mockito.when(getAccountDetailsByKeyRepository.getGroundingDetails(ArgumentMatchers.anyString())).thenReturn(listGroundDetails);
			return getAccountDetailsByKeyRepository;
	}
	
	public static GetVehicleInformationByKeyRepository getVehicleInformationByKeyRepository(Boolean insert){
		GetVehicleInformationByKeyRepository getVehicleInformationByKeyRepository = Mockito.mock(GetVehicleInformationByKeyRepository.class);
		ASPVehicleInfo asp = new ASPVehicleInfo();
		asp.setBrand("brand");
		asp.setVin("123456");
		asp.setBrand("TOYATA");
		List<ASPVehicleInfo> list = new ArrayList<>();
		if(insert)
		list.add(asp);
		Integer returnValue = new Integer(1);
		Mockito.when(getVehicleInformationByKeyRepository.findByAccount(ArgumentMatchers.anyString())).thenReturn(list);
		Mockito.when(getVehicleInformationByKeyRepository.updateVehicleInfo(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(returnValue);
		Mockito.when(getVehicleInformationByKeyRepository.insertVehicleInfo(ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString(),
				ArgumentMatchers.anyString(),ArgumentMatchers.anyInt(),ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(returnValue);
		return getVehicleInformationByKeyRepository;
	}
	public static GetReasonForReturnByTenantIdRepository getReasonForReturnByTenantIdRepository(){
		GetReasonForReturnByTenantIdRepository getReasonForReturnByTenantIdRepository = Mockito.mock(GetReasonForReturnByTenantIdRepository.class);
		ASPParamInfo aSPParamInfo = new ASPParamInfo();
		aSPParamInfo.setTenantId("1234567");
		aSPParamInfo.setParamName("building");
		aSPParamInfo.setParamValue("777");
		List<ASPParamInfo> list = new ArrayList<>();
		list.add(aSPParamInfo);
		Mockito.when(getReasonForReturnByTenantIdRepository.findByTenant(ArgumentMatchers.anyString(),ArgumentMatchers.anyString())).thenReturn(list);
		return getReasonForReturnByTenantIdRepository;
	}
	
	public static RestHelper testRestForGetAccountDetailsbyKey() {
		RestHelper restHelper = Mockito.mock(RestHelper.class);
		GetAccountDetailsByKeyRequest request = new GetAccountDetailsByKeyRequest();
		request.setLookupKey("FullVINOnly");
		request.setLookupValue("JM3KFBDM0K1698372");
		request.setReturnLimit(100);
		AccountDetailsByKeyResponse response = new AccountDetailsByKeyResponse();
		response.setActivityId("00000054-4B17-48e7-B902-79012AF2DE14");
		AccountExtension accountExtension = new AccountExtension();
		accountExtension.setApplicationId("11144");
		accountExtension.setBaseRent(377.5600);
		accountExtension.setDaysDelinquent(0);
		accountExtension.setExistingAccount("Y");
		accountExtension.setLastExtensionDate("2020-03-03T00:00:00");
		accountExtension.setNetCapCost(26650.0000);
		accountExtension.setNumberOfExtensions(0);
		accountExtension.setPastDue150(0);
		accountExtension.setPastDue90(0);
		Collateral collresponse = new Collateral();
		collresponse.setMake("MAZDA");
		collresponse.setModel("SD");
		collresponse.setModelDescription("CX-5 AWD");
		collresponse.setVin("JM3KFBDM0K1698372");
		collresponse.setYear(19);
		collresponse.setStyle("");
		collresponse.setVehicleLicensePlate("");
		collresponse.setVehicleLicensePlateState("CA");
		List<Collateral> listColl =new ArrayList<>();
		listColl.add(collresponse);
		 
		BorrowerInformationDetailsByKey borrResponse = new BorrowerInformationDetailsByKey();
		borrResponse.setBorrowerId("");
		borrResponse.setBorrowerType("1");
		borrResponse.setFirstName("");
		borrResponse.setLastName("ACB COMPANY LTD");
		borrResponse.setEmail("");
		borrResponse.setHomePhone("7878999900");
		borrResponse.setBusinessPhone("7878999900");
		borrResponse.setAddress1("MRP");
		borrResponse.setCity("Carson");
		borrResponse.setState("CA");
		borrResponse.setCountry("USA");
		borrResponse.setLanguagePreference("E");
		borrResponse.setZip("90746");
		borrResponse.setBankruptcyCode("");
		List<BorrowerInformationDetailsByKey> borrList = new ArrayList<>();
		borrList.add(borrResponse);
		
		AccountInformationDetailsByKey accResponse = new AccountInformationDetailsByKey();
				
		accResponse.setAccountArea("N");
		accResponse.setAccountBalance(0.0);
		accResponse.setAccountBranding("Standard");
		accResponse.setAccountNumber("0500000804");
		accResponse.setMaturityDate("2024-03-03T00:00:00");
		accResponse.setRepossessionStatus("Yes");
		accResponse.setProduct("LEASE");
		accResponse.setTotalPayment(1000);
		accResponse.setTotalPaymentAmountRemaining(19431.21);
		accResponse.setTotalRemainingTaxCreditAmount(0.0);
		
		accResponse.setCollateral(listColl);
		accResponse.setAccountExtension(accountExtension);
		accResponse.setBorrowerInformation(borrList);
		
		List<AccountInformationDetailsByKey> accList = new ArrayList<>();
		accList.add(accResponse);
		
		response.setAccountInformation(accList);
		Mockito.when(restHelper.restForGetAccountDetailsbyKey(ArgumentMatchers.any(GetAccountDetailsByKeyRequest.class), ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(response);
		return restHelper;
	}
	
	
	public static GetGroundingDetailsService getGroundingDetails() {
		GetGroundingDetailsService GetGroundingDetailsService = Mockito.mock(GetGroundingDetailsService.class);
		Mockito.when(GetGroundingDetailsService.updateDealerAction(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(true);
		return GetGroundingDetailsService;
	}
		
	
	public static GetGroundingDetailsRepository getGroundingDetailsRepository(){
		GetGroundingDetailsRepository getGroundingDetailsRepository = Mockito.mock(GetGroundingDetailsRepository.class);
		Mockito.when(getGroundingDetailsRepository.updateDealerAction(ArgumentMatchers.anyString(), ArgumentMatchers.anyString())).thenReturn(1);
		return getGroundingDetailsRepository;
}
}
