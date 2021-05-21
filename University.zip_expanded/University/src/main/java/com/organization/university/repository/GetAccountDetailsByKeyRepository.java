package com.organization.university.repository;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.organization.university.dto.ASPAccountInfo;
import com.organization.university.dto.GroudingDetails;

public interface GetAccountDetailsByKeyRepository extends JpaRepository<ASPAccountInfo, Integer>{

	 @Modifying
	 @Transactional
	 @Query(value =
	 "INSERT INTO asp.asp_account_info (vin,account_number,as_of_date,account_type,account_name,lease_type,account_charge_off,"
	 + "account_repo, account_bankruptcy,maturity_date,remaining_pmts,pay_off_amt,pay_off_goodthru_date,residual_amt,admin_fee,tenant_id,"
	 + "created_date,created_by,updated_date,updated_by) VALUES ('789', '133445555','2001-07-13', 'LEASE','kt','yyy','ttt','ttt','uyuyu',"
	 + "'2001-07-13',11,11,'2001-07-13',11,11,'yuyu','2001-07-13','iio','2001-07-13','yurrr')"
	  , nativeQuery = true)
	 public Integer insertAccountInfo();
	 
	 
	 @Modifying
		@Transactional
	    @Query(value = "INSERT INTO asp.asp_account_info (vin,account_number,as_of_date,account_type,lease_type, lesse_name,  " + 
	    		" account_repo, account_bankruptcy,maturity_date,remaining_pmts,pay_off_amt) VALUES ( :vin,:accountnumber, :asOfDate, :product, :borrowerType,  :leaseName ,"
	    		+ " :repossessionStatus, :bankruptcyCode, :maturityDate, :remainingPayment,  :pay_off_amt ) ", nativeQuery = true)
		public Integer insertAccountInfo(String accountnumber, String vin, LocalDateTime asOfDate, String product,
				String borrowerType, String leaseName, String repossessionStatus,  
				String bankruptcyCode, LocalDateTime maturityDate, int remainingPayment, int pay_off_amt
				);
		
	 @Modifying
		@Transactional
	    @Query(value = " update asp.asp_account_info set  as_of_date = :asOfDate, "
	    		+ " account_type = :account_type, lease_type = :borrowerType , lesse_name = :leaseName, "
	    		+ " account_repo = :repossessionStatus,  account_bankruptcy = :bankruptcyCode, maturity_date = :maturityDate , "
	    		+ " remaining_pmts =  :remainingPayment, pay_off_amt= :pay_off_amt where  vin = :vin and account_number = :accountnumber ", nativeQuery = true)
		public Integer updateAccountInfo(String accountnumber, String vin, LocalDateTime asOfDate, String account_type,
				String borrowerType, String leaseName, String repossessionStatus,  
				String bankruptcyCode, LocalDateTime maturityDate, int remainingPayment, int pay_off_amt
				);

	 @Modifying
		@Transactional
	    @Query(value = " select vin,account_number,as_of_date,account_type,lease_type,lesse_name,account_charge_off, account_repo, "
	    		+ " maturity_date, remaining_pmts, pay_off_amt, pay_off_goodthru_date from asp.asp_account_info where vin = :vin and "
	    		+ " account_number = :accountNumber"
	    	, nativeQuery = true)
	public List<ASPAccountInfo> findByAccountNumberAndVin(String accountNumber, String vin);
	
	 
	 public  List<GroudingDetails> getGroundingDetails(String dealerNumber); 
	 
	 public  List<GroudingDetails> getAllGroundingDetails(String dealerNumber);


	 @Modifying
	 @Transactional
	 @Query(value = " update asp.asp_grounding set  dealer_action = :dealerAction "
	    		+ "where  vin = :vin", nativeQuery = true)
	public void updateDealerAction(String dealerAction, String vin);
		
	}