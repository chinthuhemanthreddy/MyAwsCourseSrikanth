package com.organization.university.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountInformationReponse {

@JsonProperty("ActivityId")
private String activityId;
@JsonProperty("Errors")
private String errors;
@JsonProperty("HasErrors")
private boolean hasErrors;
@JsonProperty("AccountInformation")
private List<AccountInformation> accountInformation;

}
