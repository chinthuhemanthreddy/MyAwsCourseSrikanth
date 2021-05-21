package com.organization.university.model;

public class TokenResponse {

	String token_type;
	
	int expires_in;
	
	String access_token;

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	@Override
	public String toString() {
		return "TokenResponse [token_type=" + token_type + ", expires_in=" + expires_in + ", access_token="
				+ access_token + "]";
	}

	
	}
