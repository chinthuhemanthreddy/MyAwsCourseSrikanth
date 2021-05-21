package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAccountDetailsByKeyRequest {

	@JsonProperty("LookupKey")
	private String lookupKey;
	@JsonProperty("LookupValue")
	private String lookupValue;
	@JsonProperty("ReturnLimit")
	private int returnLimit;
	@JsonProperty("TenantContext")
	private TenantContext tenantContext;
	@JsonProperty("ActivityContext")
	private ActivityContext activityContext;




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

	public int getReturnLimit() {
		return returnLimit;
	}

	public void setReturnLimit(int returnLimit) {
		this.returnLimit = returnLimit;
	}

	public TenantContext getTenantContext() {
		return tenantContext;
	}

	public void setTenantContext(TenantContext tenantContext) {
		this.tenantContext = tenantContext;
	}

	public ActivityContext getActivityContext() {
		return activityContext;
	}

	public void setActivityContext(ActivityContext activityContext) {
		this.activityContext = activityContext;
	}
	
	
	
}
