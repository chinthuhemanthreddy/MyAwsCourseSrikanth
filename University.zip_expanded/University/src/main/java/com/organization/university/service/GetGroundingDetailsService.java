package com.organization.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.organization.university.custom.exception.CustomException;
import com.organization.university.dto.GroudingDetails;
import com.organization.university.repository.GetGroundingDetailsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GetGroundingDetailsService {

	@Autowired
	private final GetGroundingDetailsRepository getGroundingDetailsRepository;

	public List<GroudingDetails> getGroundingDetails() {
		List<GroudingDetails> groundDetails = null;
		try {
		log.info(" entering into getGroundingDetails in service class ");
		groundDetails = getGroundingDetailsRepository.getGroundingDetails();
		log.info("leaving  getGroundingDetails for return service method:::"+groundDetails);
		}catch(Exception ex) {
			log.error("exception in execute getReasonForReturn ::: " + ex.getMessage());
			throw new CustomException(
					"Failing while gettoken service calling.  Excpetion is : " + ex.getMessage() + ", HttCode: "  + HttpStatus.INTERNAL_SERVER_ERROR.value(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return groundDetails;
	}

	public boolean updateDealerAction(String dealerAction, String vin) {
		try {
			log.info(" entering into updateDealerAction in service class ");
			int updatedValue=0;
			if(dealerAction.contentEquals("PassedVehicles") || dealerAction.contentEquals("PurchasedVehicles")){
				updatedValue = getGroundingDetailsRepository.updateDealerAction(dealerAction, vin);
			}else{
				return false;
			}
			log.info("leaving  updateDealerAction for return service method:::"+updatedValue);
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
