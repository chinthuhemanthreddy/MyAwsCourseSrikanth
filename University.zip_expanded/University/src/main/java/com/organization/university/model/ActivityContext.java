package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityContext {

	@JsonProperty("UserId")
	private String userId;
	@JsonProperty("ActivityId")
	private String activityId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getActivityId() {
		return activityId;
	}
	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
	
	
	
	
}
