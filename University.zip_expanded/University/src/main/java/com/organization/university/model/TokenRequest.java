package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenRequest {
	@JsonProperty("client_id")
	private String clientId;
	@JsonProperty("client_secret")
	private String clientSecret;
	@JsonProperty("grant_type")
	private String grantTypeDev;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getGrantTypeDev() {
		return grantTypeDev;
	}

	public void setGrantTypeDev(String grantTypeDev) {
		this.grantTypeDev = grantTypeDev;
	}
	
	
	
}

