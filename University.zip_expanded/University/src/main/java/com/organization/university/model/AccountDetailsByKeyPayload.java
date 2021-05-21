package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDetailsByKeyPayload {
	
	@JsonProperty("LookupKey")
	private String lookupKey;
	
	@JsonProperty("LookupValue")
	private String lookupValue;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	public String getLookupValue() {
		return lookupValue;
	}

	public void setLookupValue(String lookupValue) {
		this.lookupValue = lookupValue;
	}

	@Override
	public String toString() {
		return "AccountDetailsByKeyPayload :::: [lookupKey=" + lookupKey + ", lookupValue=" + lookupValue + "]";
	}
	
	

}
