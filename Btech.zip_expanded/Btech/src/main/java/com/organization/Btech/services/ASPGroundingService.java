package com.organization.Btech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.Btech.daomodel.ASPGrounding;
import com.organization.Btech.model.UpdateGroundDetails;
import com.organization.Btech.repo.ASPGroundingRepository;

@Service
public class ASPGroundingService {

	@Autowired
	private ASPGroundingRepository aspGroundingRepository;
	
	
	public List<ASPGrounding> getGroundingdetails() {
		
		System.out.println("before calling the database for aspGrounding::::");
		
		List<ASPGrounding> aspGrounding = aspGroundingRepository.findAll();

		System.out.println("after calling the database for aspGrounding:::: "+aspGrounding);
		return aspGrounding;
		
	}


	public int updateGroundingDate(UpdateGroundDetails updateGroundDetails) {

		int updateCount = aspGroundingRepository.updateGroundingDate(updateGroundDetails.getAccount_number(),updateGroundDetails.getReturn_date());
	
		return updateCount;
	}
}
