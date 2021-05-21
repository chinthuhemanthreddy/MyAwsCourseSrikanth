package com.organization.university.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInfoPayload {
	@JsonProperty("TenantContext")
	private TenantContext tenantContext;
	@JsonProperty("ActivityContext")
	private ActivityContext activityContext;
	@JsonProperty("AccountNumbers")
	private List<String> accountNumbers;
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
	public List<String> getAccountNumbers() {
		return accountNumbers;
	}
	public void setAccountNumbers(List<String> accountNumbers) {
		this.accountNumbers = accountNumbers;
	}
	
	
	

	
}
