package com.test.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.organization.university.contoller.DefiServiceCallingController;
import com.test.util.MockProviderUtil;

public class TestDefiServiceCallingController {

	private DefiServiceCallingController defiServiceController;
	
	private MockMvc mvc;
	
	
	@BeforeEach
	public void init() {

		defiServiceController = new DefiServiceCallingController(MockProviderUtil.getDefiService());
		mvc = MockMvcBuilders.standaloneSetup(defiServiceController).build();
		}
	
	@Test
	public void testGetAccountDetails() throws Exception{

		mvc.perform(MockMvcRequestBuilders.post("/getAccountDetails")
				.contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "test")
				.content("{ \"grant_type\" : \"client_credentials\",\"client_id\" : \"0oaxox9wq1633Vljm0h7\",\"client_secret\" : \"SsRgC6iwc6KGxytMZdflK4cO7bxfBSw8LxTJbZVa\"}"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	
	@Test
	public void testGetTokenData() throws Exception{

		mvc.perform(MockMvcRequestBuilders.post("/tokenData")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	
}
