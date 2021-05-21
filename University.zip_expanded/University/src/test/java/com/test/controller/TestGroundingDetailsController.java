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

import com.organization.university.contoller.GetGroundingDetailsController;
import com.test.util.MockProviderUtil;

public class TestGroundingDetailsController {

	private GetGroundingDetailsController getGroundingDetailsController;
	private MockMvc mvc;
	
	@BeforeEach
	public void init() throws ParseException, IOException {

		getGroundingDetailsController = new GetGroundingDetailsController(MockProviderUtil.getGroundingDetails());
		mvc = MockMvcBuilders.standaloneSetup(getGroundingDetailsController).build();
		
	}

	@Test
	public void testUpdateDealerAction() throws Exception {

		mvc.perform(MockMvcRequestBuilders.post("/DealerAction")
				.contentType(MediaType.APPLICATION_JSON)
				.param("vin" , "23546789")
				.param("dealerAction", "pass"))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
}
