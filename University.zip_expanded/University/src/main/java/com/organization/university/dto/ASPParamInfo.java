package com.organization.university.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ASPParamInfo {

	@Id
	private String tenantId;
	private String paramValue;
	private String paramName;
	private String paramDescription;
}
