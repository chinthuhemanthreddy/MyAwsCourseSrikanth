package com.organization.university.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
public class UniversityEmployeeService {

	@Value("${grant_type_dev}")
	 private String client_credentials;
	@Value("${client_id_dev}")
	 private String client_id;
	@Value("${client_secret_dev}")
	 private String client_secret;
	@Value("${token_service_dev}")
	 private String token_service_dev;
	
	
	public HttpHeaders getHeader() {
		
		HttpHeaders headers = new HttpHeaders();
		System.out.println("client_credentials ::: "+client_credentials);
		headers.set("grant_type", client_credentials);
		System.out.println("client_id ::: "+client_id);
		headers.set("client_id", client_id);
		System.out.println("client_secret ::: "+client_secret);
		headers.set("client_secret", client_secret);
		return headers;
	}
	
}
