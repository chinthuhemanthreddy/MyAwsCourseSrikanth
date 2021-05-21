package com.organization.university.contoller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.organization.university.model.AccountInfoPayload;
import com.organization.university.model.AccountInformationReponse;
import com.organization.university.service.DefiService;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
@Api(value = "University")
public class DefiServiceCallingController {

	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class API {

		public static final String TOKEN_DATA = "/tokenData";

		private static final String GET_ALL_ACCOUNT_DETAILS = "/getAccountDetails";
		
		private static final String GET_TestService = "/testService";

	}

	@Autowired
	private final DefiService defiService;

	 @PostMapping(path  = API.TOKEN_DATA) 
	 public ResponseEntity<String> getTokenData() {
		 log.info("Entering into  DefiServiceCallingController for token...");
		return new ResponseEntity<String>(defiService.getTokenData(),HttpStatus.OK);
	 }
	 
	 @PostMapping(path  = API.GET_ALL_ACCOUNT_DETAILS)
	public ResponseEntity<AccountInformationReponse> getAccountDetails(@RequestBody AccountInfoPayload payload,
			@RequestHeader("Authorization") String authorization) throws IOException {
		 
		 log.info("Entering into getAccountDetails data Controller...");
		 
		 return new  ResponseEntity<AccountInformationReponse>(defiService.getAccountDetails(payload,authorization),HttpStatus.OK);

	}
	 
	 @PostMapping(path  = API.GET_TestService)
		public String getTestService() {
			 
			 log.info("Entering into getTestService data Controller...");
			return " test Service called ";
			 
			
		}
}