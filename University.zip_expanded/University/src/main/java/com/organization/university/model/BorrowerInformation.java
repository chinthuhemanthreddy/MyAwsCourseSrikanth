package com.organization.university.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class BorrowerInformation {

	@JsonProperty("BorrowerId")
	private String borrowerId;
	@JsonProperty("BorrowerType")
	private String borrowerType;
	@JsonProperty("FirstName")
	private String FirstName;
	@JsonProperty("LastName")
	private String lastName;
	@JsonProperty("Email")
	private String email;
	@JsonProperty("EmailExpressedConsent")
	private String emailExpressedConsent;
	@JsonProperty("EmailDNC")
	private String emailDNC;
	@JsonProperty("HomePhone")
	private String homePhone;
	@JsonProperty("CellPhone")
	private String cellPhone;
	@JsonProperty("BusinessPhone")
	private String businessPhone;
	@JsonProperty("Fax")
	private String fax;
	@JsonProperty("Address1")
	private String address1;
	@JsonProperty("Address2")
	private String address2;
	@JsonProperty("City")
	private String city;
	@JsonProperty("State")
	private String state;
	@JsonProperty("Country")
	private String country;
	@JsonProperty("LanguagePreference")
	private String languagePreference;
	@JsonProperty("Zip")
	private String zip;
	@JsonProperty("GaragingAddress1")
	private String garagingAddress1;
	@JsonProperty("GaragingAddress2")
	private String garagingAddress2;
	@JsonProperty("GaragingCity")
	private String garagingCity;
	@JsonProperty("GaragingState")
	private String garagingState;
	@JsonProperty("GaragingZip")
	private String garagingZip;
	@JsonProperty("ContactId")
	private String contactId;
	@JsonProperty("DeceasedFlag")
	private String deceasedFlag;
	@JsonProperty("HomePhoneDNC")
	private String homePhoneDNC;
	@JsonProperty("HomePhoneExpressedConsent")
	private String homePhoneExpressedConsent;
	@JsonProperty("CellPhoneDNC")
	private String cellPhoneDNC;
	@JsonProperty("CellPhoneExpressedConsent")
	private String cellPhoneExpressedConsent;
	@JsonProperty("SMSBlocked")
	private String sMSBlocked;
	@JsonProperty("BusinessPhoneDNC")
	private String businessPhoneDNC;
	@JsonProperty("BusinessPhoneExpressedConsent")
	private String businessPhoneExpressedConsent;
	@JsonProperty("Ssn")
	private String ssn;
	@JsonProperty("Dob")
	private LocalDateTime dob;
	@JsonProperty("BankruptcyCode")
	private String bankruptcyCode;
	@JsonProperty("OfacFlag")
	private String ofacFlag;
	@JsonProperty("ConsumerBusinessIndicator")
	private String consumerBusinessIndicator;
	@JsonProperty("AlertDetails")
	private String alertDetails;
	@JsonProperty("ActiveMilitaryFlag")
	private String activeMilitaryFlag;
	public String getActiveMilitaryFlag() {
		return activeMilitaryFlag;
	}
	public void setActiveMilitaryFlag(String activeMilitaryFlag) {
		this.activeMilitaryFlag = activeMilitaryFlag;
	}
	
	
	
}
