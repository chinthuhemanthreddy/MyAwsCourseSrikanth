package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class AccountExtension {

	@JsonProperty("ExistingAccount")
	private String existingAccount;
	@JsonProperty("ApplicationId")
	private String applicationId;
	@JsonProperty("DaysDelinquent")
	private int daysDelinquent;
	@JsonProperty("EcoaIndicator")
	private String ecoaIndicator;
	@JsonProperty("ChargeOffIndicator")
	private String chargeOffIndicator;
	@JsonProperty("CmsActivity")
	private String cmsActivity;
	@JsonProperty("OpenDate")
	private String openDate;
	@JsonProperty("OriginalAmount")
	private double originalAmount;
	@JsonProperty("RemainingTerm")
	private int remainingTerm;
	@JsonProperty("NetCapCost")
	private double netCapCost;
	@JsonProperty("BaseRent")
	private double baseRent;
	
	@JsonProperty("LeaseTermType")
	private String leaseTermType;
	@JsonProperty("NetInvestment")
	private String netInvestment;
	@JsonProperty("PastDue30")
	private double pastDue30;
	@JsonProperty("PastDue60")
	private double pastDue60;
	@JsonProperty("PastDue90")
	private double pastDue90;
	@JsonProperty("PastDue120")
	private double pastDue120;
	@JsonProperty("PastDue150")
	private double pastDue150;
	@JsonProperty("Times15")
	private int times15;
	@JsonProperty("Times30")
	private int times30;
	@JsonProperty("Times60")
	private int times60;
	@JsonProperty("Times90")
	private int times90;
	@JsonProperty("Times120")
	private int times120;
	@JsonProperty("Times150")
	private int times150;
	@JsonProperty("NsfCount")
	private int nsfCount;
	@JsonProperty("LastExtensionDate")
	private String lastExtensionDate;
	@JsonProperty("NumberOfExtensions")
	private int numberOfExtensions;
	
}
