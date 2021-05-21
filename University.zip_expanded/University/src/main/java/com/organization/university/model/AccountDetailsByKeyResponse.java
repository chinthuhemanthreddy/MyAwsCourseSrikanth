package com.organization.university.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDetailsByKeyResponse {
	@JsonProperty("ActivityId")
	private String activityId;
	@JsonProperty("Errors")
	private String errors;
	@JsonProperty("HasErrors")
	private boolean hasErrors;
	@JsonProperty("AccountInformation")
	private List<AccountInformationDetailsByKey> accountInformation;
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	public String getErrors() {
		return errors;
	}
	public void setErrors(String errors) {
		this.errors = errors;
	}
	public boolean isHasErrors() {
		return hasErrors;
	}
	public void setHasErrors(boolean hasErrors) {
		this.hasErrors = hasErrors;
	}
	public List<AccountInformationDetailsByKey> getAccountInformation() {
		return accountInformation;
	}
	public void setAccountInformation(List<AccountInformationDetailsByKey> accountInformation) {
		this.accountInformation = accountInformation;
	}

	
}
