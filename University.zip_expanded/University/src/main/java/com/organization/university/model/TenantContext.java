package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TenantContext {
	
	@JsonProperty("ConsumerSystemId")
	private String consumerSystemId;
	@JsonProperty("ClientId")
	private String clientId;
	@JsonProperty("ConsumerEnvironmentId")
	private String consumerEnvironmentId;
	@JsonProperty("TenantId")
	private String tenantId;
	
	
	public String getConsumerSystemId() {
		return consumerSystemId;
	}
	public void setConsumerSystemId(String consumerSystemId) {
		this.consumerSystemId = consumerSystemId;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getConsumerEnvironmentId() {
		return consumerEnvironmentId;
	}
	public void setConsumerEnvironmentId(String consumerEnvironmentId) {
		this.consumerEnvironmentId = consumerEnvironmentId;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	

}
