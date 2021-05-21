package com.organization.university.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.university.contoller.GetAccountDetailsByKeyController.API;
import com.organization.university.dto.GroudingDetails;
import com.organization.university.service.GetGroundingDetailsService;

import io.swagger.annotations.Api;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@RestController
@Log4j2
@RequiredArgsConstructor
@Api(value = "University")
public class GetGroundingDetailsController {

	@Autowired
	private final GetGroundingDetailsService getGroundingDetailsService;
	
	@NoArgsConstructor(access = AccessLevel.PRIVATE)
	public static final class API {
		private static final String GET_ALL_DETAILS= "/getGroundingDetailsss";
		private static final String TEST_SERVICE ="/testServiceDetails";
		private static final String UPDATE_DEALER_ACTION = "/DealerAction";
	}
	 
	 @PostMapping(path =API.GET_ALL_DETAILS)
		public ResponseEntity<List<GroudingDetails>> getAllDetails() {
		 	 log.info("in getAllDetails data Controller response entity  ...");
			 List<GroudingDetails> groundingDetails = getGroundingDetailsService.getGroundingDetails();
			 log.info("accountInformationReponse :: "+groundingDetails.toString());
			 return new ResponseEntity<List<GroudingDetails>>(groundingDetails,HttpStatus.OK);

		}
	 
	 @RequestMapping(value={API.TEST_SERVICE})
		public ResponseEntity<GroudingDetails> getServiceDetails() {
		 	 log.info("in getServiceDetails data Controller response entity  ...");
		 	GroudingDetails g =new GroudingDetails();
		 	g.setAccount_type("cokvlsd");
			 return new ResponseEntity<GroudingDetails>(g,HttpStatus.OK);

		}
	 
	 @PostMapping(value =API.UPDATE_DEALER_ACTION)
		public Map<String,Boolean> updateDealerAction(@RequestParam String vin, @RequestParam String dealerAction) {
		 log.info("in updateDealerAction data Controller response entity  ...");
		 boolean isUpdated = getGroundingDetailsService.updateDealerAction(dealerAction, vin);
		 Map<String,Boolean> response = new HashMap();
		 if(isUpdated){
			response.put("SUCCESS", true);
		 }else{
			response.put("SUCCESS", false);
		 }
		 return  response;

		}
	 
}
