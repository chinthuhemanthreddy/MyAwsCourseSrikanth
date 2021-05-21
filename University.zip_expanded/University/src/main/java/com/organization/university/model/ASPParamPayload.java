package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ASPParamPayload {

	@JsonProperty("tenantId")
	private String tenantId;
	@JsonProperty("paramName")
	private String paramName;
	
	
}
