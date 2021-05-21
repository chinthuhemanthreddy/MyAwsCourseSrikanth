package com.test.controller;

import java.io.IOException;

import org.apache.http.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.organization.university.contoller.GetAccountDetailsByKeyController;
import com.organization.university.model.ASPParamPayload;
import com.test.util.MockProviderUtil;

public class TestGetAccountDetailsByKeyController {

	private GetAccountDetailsByKeyController getAccountDetailsByKeyController;
	private MockMvc mvc;
	
	@BeforeEach
	public void init() throws ParseException, IOException {

		getAccountDetailsByKeyController = new GetAccountDetailsByKeyController(MockProviderUtil.getAccountDetailsByKey());
		mvc = MockMvcBuilders.standaloneSetup(getAccountDetailsByKeyController).build();
		
	}

	@Test
	public void testGetAccountDetailsByKey() throws Exception{

		mvc.perform(MockMvcRequestBuilders.post("/getAccountDetailsBykey")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "authtoken...")
				.content("{ \"LookupKey\" : \"FullVINOnly\",\"LookupValue\" : \"JM3KFBDM0K1698372\"} "))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	
	@Test
	public void testgetAllDetails() throws Exception{

		mvc.perform(MockMvcRequestBuilders.post("/getGroundingDetails")
				.contentType(MediaType.APPLICATION_JSON)
				.param("dealerId" , "23546789"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	
	
	
	@Test
	public void getReasonForReturn() throws Exception{
		
		mvc.perform(MockMvcRequestBuilders.post("/getAspParamsByTenantId")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "authtoken...")
				.content("{ \"tenantId\" : \"FullVINOnly\",\"paramName\" : \"JM3KFBDM0K1698372\"} "))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	
	
}
