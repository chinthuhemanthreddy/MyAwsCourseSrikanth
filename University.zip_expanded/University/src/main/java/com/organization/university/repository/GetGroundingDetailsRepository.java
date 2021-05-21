package com.organization.university.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.organization.university.dto.ASPGroundDetails;
import com.organization.university.dto.GroudingDetails;

public interface GetGroundingDetailsRepository  extends JpaRepository<ASPGroundDetails, Integer>{

	
	
	/*
	 * @Modifying
	 * 
	 * @Transactional
	 * 
	 * @Query(value =
	 * "select empid,depname,empname,u.encrypted_password,first_name,user_id,last_name from testtempemployee t, users u where u.id = t.empid"
	 * , nativeQuery = true) public List<ASPGroundDetails> findDetailsbyId();
	 */
	  
	  public  List<GroudingDetails> getGroundingDetails();

	  @Modifying
		@Transactional
	    @Query(value = " update asp.asp_grounding set  dealer_action = :dealerAction "
	    		+ "where  vin = :vin", nativeQuery = true)
		public int updateDealerAction(String dealerAction, String vin); 
	 
}
