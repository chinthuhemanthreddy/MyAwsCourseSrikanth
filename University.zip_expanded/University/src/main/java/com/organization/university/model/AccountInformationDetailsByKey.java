package com.organization.university.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class AccountInformationDetailsByKey {


	@JsonProperty("AccountNumber")
	private String accountNumber;
	@JsonProperty("Product")
	private String product;
	@JsonProperty("CollateralType")
	private String collateralType;
	@JsonProperty("AccountStatus")
	private String accountStatus;
	@JsonProperty("AccountArea")
	private String accountArea;
	@JsonProperty("CreditBalanceIndicator")
	private String creditBalanceIndicator;
	@JsonProperty("DaysPastDue")
	private int daysPastDue;
	@JsonProperty("AmountPastDue")
	private double amountPastDue;
	@JsonProperty("LastPaymentDate")
	private String lastPaymentDate;
	@JsonProperty("LastPaymentAmount")
	private double lastPaymentAmount;
	@JsonProperty("NextPaymentDate")
	private String nextPaymentDate;
	@JsonProperty("SinglePayLease")
	private String singlePayLease;
	@JsonProperty("DueDay")
	private int dueDay;
	@JsonProperty("StartDate")
	private String startDate;
	@JsonProperty("MaturityDate")
	private String maturityDate;
	@JsonProperty("MonthsRemaining")
	private int monthsRemaining;
	@JsonProperty("BasePayment")
	private double basePayment;
	@JsonProperty("BaseTaxPayment")
	private double baseTaxPayment;
	@JsonProperty("TotalPayment")
	private double totalPayment;
	@JsonProperty("APRRate")
	private double aPRRate;
	@JsonProperty("AccountBranding")
	private String accountBranding;
	@JsonProperty("StopPayment")
	private String stopPayment;
	@JsonProperty("DealerName")
	private String dealerName;
	@JsonProperty("DealerState")
	private String dealerState;
	@JsonProperty("PaymentFrequency")
	private String paymentFrequency;
	@JsonProperty("TotalPaymentAmountRemaining")
	private double totalPaymentAmountRemaining;
	@JsonProperty("OtherReceivables")
	private double otherReceivables;
	@JsonProperty("Term")
	private int term;
	@JsonProperty("BookingDate")
	private String bookingDate;
	@JsonProperty("PaymentsMade")
	private int paymentsMade;
	@JsonProperty("PaymentsRemaining")
	private int paymentsRemaining;
	@JsonProperty("AccountBalance")
	private double accountBalance;
	@JsonProperty("StatementPreferenceIndicator")
	private String statementPreferenceIndicator;
	@JsonProperty("BorrowerInformation")
	private List<BorrowerInformationDetailsByKey> borrowerInformation;
	@JsonProperty("Collateral")
	private List<Collateral> collateral;
	@JsonProperty("PaidToDate")
	private String paidToDate;
	@JsonProperty("CreditScore")
	private String creditScore;
	@JsonProperty("CreditTier")
	private String creditTier;
	@JsonProperty("OutstandingPaymentDue")
	private double outstandingPaymentDue;
	@JsonProperty("CeaseandDesistFlag")
	private String ceaseandDesistFlag;
	@JsonProperty("SCRAFlag")
	private String sCRAFlag;
	@JsonProperty("AccountBlockWebFlag")
	private String accountBlockWebFlag;
	@JsonProperty("AlertDetails")
	private String alertDetails;
	@JsonProperty("PayoffQuoteUnavailable")
	private boolean payoffQuoteUnavailable;
	@JsonProperty("TotalRemainingTaxCreditAmount")
	private double totalRemainingTaxCreditAmount;
	@JsonProperty("CurrentBusinessDate")
	private String currentBusinessDate;
	@JsonProperty("CurrentInterestBalance")
	private double currentInterestBalance;
	@JsonProperty("CurrentPrincipalBalance")
	private double currentPrincipalBalance;
	@JsonProperty("InterestPerDiem")
	private double interestPerDiem;
	@JsonProperty("LateFeeBalance")
	private double lateFeeBalance;
	@JsonProperty("NetPayoffAmount")
	private double netPayoffAmount;
	@JsonProperty("CloseOutType")
	private String closeOutType;
	@JsonProperty("RecoveryStatus")
	private String recoveryStatus;
	@JsonProperty("BankruptcyIndicator")
	private String bankruptcyIndicator;
	@JsonProperty("RepossessionStatus")
	private String repossessionStatus;
	@JsonProperty("RepossessionApprovalType")
	private String repossessionApprovalType;
	@JsonProperty("AccrualSuspendedFlag")
	private String accrualSuspendedFlag;
	@JsonProperty("ExtensionInProgress")
	private String extensionInProgress;
	@JsonProperty("VehicleSaleType")
	private String vehicleSaleType;
	@JsonProperty("LiabilityBillingInformationAvailable")
	private String liabilityBillingInformationAvailable;
	@JsonProperty("InspectionInformationAvailable")
	private String inspectionInformationAvailable;
	@JsonProperty("RenewalMaturityDate")
	private String renewalMaturityDate;
	@JsonProperty("OriginalMaturityDate")
	private String originalMaturityDate;
	@JsonProperty("ExtendedMaturityDate")
	private String extendedMaturityDate;
	@JsonProperty("RepossessionAssignedFlag")
	private String repossessionAssignedFlag;
	@JsonProperty("DealerId")
	private String dealerId;
	@JsonProperty("PayoffSalesTax")
	private double payoffSalesTax;
	@JsonProperty("PayoffSalesTaxRate")
	private double payoffSalesTaxRate;
	@JsonProperty("PayoffContractObligation")
	private double payoffContractObligation;
	@JsonProperty("PayoffFutureRent")
	private double payoffFutureRent;
	@JsonProperty("PayoffCurrentRent")
	private double payoffCurrentRent;
	@JsonProperty("PayoffPaymentRent")
	private double PayoffPaymentRent;
	@JsonProperty("AccountExtension")
	private AccountExtension AccountExtension;
	
	
}
