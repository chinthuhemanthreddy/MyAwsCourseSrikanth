package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDetails {

	@JsonProperty("ErrorCode")
	private String errorCode;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("IsBusinessError")
	private boolean isBusinessError;
	@JsonProperty("EventLogId")
	private String eventLogId;
}
