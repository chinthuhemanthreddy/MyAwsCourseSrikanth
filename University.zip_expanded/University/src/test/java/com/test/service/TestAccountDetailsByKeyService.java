package com.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.organization.university.model.AccountDetailsByKeyPayload;
import com.organization.university.repository.GetVehicleInformationByKeyRepository;
import com.organization.university.service.AccountDetailsByKeyService;
import com.test.util.MockProviderUtil;

public class TestAccountDetailsByKeyService {

private AccountDetailsByKeyService accountDetailsByKeyService;
	
	
	@BeforeEach
	public void init() {

		accountDetailsByKeyService = new AccountDetailsByKeyService(
				MockProviderUtil.getAccountDetailsByKeyRepository()
				,MockProviderUtil.getVehicleInformationByKeyRepository(true)
				,MockProviderUtil.getReasonForReturnByTenantIdRepository()
				,MockProviderUtil.testRestForGetAccountDetailsbyKey());
		accountDetailsByKeyService.setTest_client_id("MAZDAUS");
		accountDetailsByKeyService.setGetaccountdetailsbykey_service_dev("http://localhost:8067");
		accountDetailsByKeyService.setTest_activity_id("00000054-4B17-48e7-B902-79012AF2DE14");
		accountDetailsByKeyService.setTest_consumer_id("AutoLL");
		accountDetailsByKeyService.setTest_env_tye("UAT");
		accountDetailsByKeyService.setTest_tenant_id("TFSMFIN");
		accountDetailsByKeyService.setTest_user_id("TFSWLI");
		}
	@Test
	public void testGetAccountDetailsByKeyResponse() {
		AccountDetailsByKeyPayload payload = new AccountDetailsByKeyPayload();
		payload.setLookupKey("test");
		payload.setLookupValue("test");
		Assertions.assertNotNull(accountDetailsByKeyService.getAccountDetailsByKeyResponse(payload, "test"));
	}
	
	@Test
	public void testInsertGetAccountDetailsByKeyResponse() {
		GetVehicleInformationByKeyRepository getVehicleInformationByKeyRepository = MockProviderUtil.getVehicleInformationByKeyRepository(false);
		accountDetailsByKeyService = new AccountDetailsByKeyService(
				MockProviderUtil.getAccountDetailsByKeyRepository()
				,getVehicleInformationByKeyRepository
				,MockProviderUtil.getReasonForReturnByTenantIdRepository()
				,MockProviderUtil.testRestForGetAccountDetailsbyKey());
		accountDetailsByKeyService.setTest_client_id("MAZDAUS");
		accountDetailsByKeyService.setGetaccountdetailsbykey_service_dev("http://localhost:8067");
		accountDetailsByKeyService.setTest_activity_id("00000054-4B17-48e7-B902-79012AF2DE14");
		accountDetailsByKeyService.setTest_consumer_id("AutoLL");
		accountDetailsByKeyService.setTest_env_tye("UAT");
		accountDetailsByKeyService.setTest_tenant_id("TFSMFIN");
		accountDetailsByKeyService.setTest_user_id("TFSWLI");
		AccountDetailsByKeyPayload payload = new AccountDetailsByKeyPayload();
		
		payload.setLookupKey("test");
		payload.setLookupValue("test");
		Assertions.assertNotNull(accountDetailsByKeyService.getAccountDetailsByKeyResponse(payload, "test"));
	}
	
	
	  @Test public void testGetGroundingDetailsResponse() {
	  
	  Assertions.assertNotNull(accountDetailsByKeyService.getGroundingDetails("test")); }
	 
	
}
