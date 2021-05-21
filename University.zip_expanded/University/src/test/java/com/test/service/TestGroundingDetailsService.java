package com.test.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.organization.university.service.GetGroundingDetailsService;
import com.test.util.MockProviderUtil;

public class TestGroundingDetailsService {

	private GetGroundingDetailsService getGroundingDetailsService;
	@BeforeEach
	public void init() {

		getGroundingDetailsService = new GetGroundingDetailsService(
				MockProviderUtil.getGroundingDetailsRepository());
		
		}
	@Test
	public void testGetGroundingDetails() {
		
		Assertions.assertNotNull(getGroundingDetailsService.updateDealerAction("PassedVehicles", "2345678"));
	}
	
}
