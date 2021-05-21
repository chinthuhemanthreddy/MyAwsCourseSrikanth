package com.organization.university.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.university.contoller.GetGroundingDetailsController.API;
import com.organization.university.dto.ASPAccountInfoAndVehicleInfo;
import com.organization.university.dto.ASPParamInfo;
import com.organization.university.dto.GroudingDetails;
import com.organization.university.dto.Testtempemployee;
import com.organization.university.dto.Users;
import com.organization.university.model.ASPParamPayload;
import com.organization.university.model.AccountDetailsByKeyPayload;
import com.organization.university.service.AccountDetailsByKeyService;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@Api(value = "University")
public class GetAccountDetailsByKeyController {
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class API {

		private static final String GET_ALL_ACCOUNT_DETAILS_BY_KEY = "/getAccountDetailsBykey";
		private static final String GET_ALL_RETURN_REASON_BY_TENANTID = "/getAspParamsByTenantId";
		private static final String GET_ALL_DETAILS= "/getGroundingDetails";
		private static final String UPDATE_DEALER_ACTION = "/DealerAction";

	}
	
	@Autowired
	private final AccountDetailsByKeyService accountDetailsByKeyService;
	
	

	 @PostMapping(path = API.GET_ALL_ACCOUNT_DETAILS_BY_KEY)
		public ResponseEntity<ASPAccountInfoAndVehicleInfo> getAccountDetailsByKey(@RequestBody AccountDetailsByKeyPayload payload,
				@RequestHeader("Authorization") String authorization) {
		    log.info("in getAccountDetails data Controller..."+payload);
			 return new ResponseEntity<ASPAccountInfoAndVehicleInfo>(accountDetailsByKeyService.getAccountDetailsByKeyResponse(payload,authorization),HttpStatus.OK);
		}
	 
	 @PostMapping(path =API.GET_ALL_RETURN_REASON_BY_TENANTID)
		public ResponseEntity<List<ASPParamInfo>> getReasonForReturn(@RequestBody ASPParamPayload payload,
				@RequestHeader("Authorization") String authorization) {
			 
		 	 log.info("in getAccountDetails data Controller response entity..."+payload);
			 List<ASPParamInfo> aspParamInfo = accountDetailsByKeyService.getReasonForReturn(payload,authorization);
			 log.info("accountInformationReponse :: "+aspParamInfo.toString());
			 return new ResponseEntity<List<ASPParamInfo>>(aspParamInfo,HttpStatus.OK);

		}
	 
	 @PostMapping(path =API.GET_ALL_DETAILS)
		public ResponseEntity<List<GroudingDetails>> getAllDetails(@RequestParam String dealerId) {
		 log.info("in getAllDetails data Controller response entity  ...");
		 List<GroudingDetails> groundingDetails = accountDetailsByKeyService.getGroundingDetails(dealerId);
		 log.info("accountInformationReponse :: "+groundingDetails.toString());
		 return new ResponseEntity<List<GroudingDetails>>(groundingDetails,HttpStatus.OK);

		}
	 
	
	 
	 
	 
}
