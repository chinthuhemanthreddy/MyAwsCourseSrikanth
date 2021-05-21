package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlertDetails {
	@JsonProperty("AlertCode")
	private String alertCode;
	@JsonProperty("AlertDescription")
	private String alertDescription;
}
