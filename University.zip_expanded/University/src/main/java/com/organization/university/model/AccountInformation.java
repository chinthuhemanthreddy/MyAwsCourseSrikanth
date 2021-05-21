package com.organization.university.model;


import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountInformation {

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
	private LocalDateTime lastPaymentDate;
	@JsonProperty("LastPaymentAmount")
	private double lastPaymentAmount;
	@JsonProperty("NextPaymentDate")
	private LocalDateTime nextPaymentDate;
	@JsonProperty("SinglePayLease")
	private String singlePayLease;
	@JsonProperty("DueDay")
	private int dueDay;
	@JsonProperty("StartDate")
	private LocalDateTime startDate;
	@JsonProperty("MaturityDate")
	private LocalDateTime maturityDate;
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
	private LocalDateTime bookingDate;
	@JsonProperty("PaymentsMade")
	private int paymentsMade;
	@JsonProperty("PaymentsRemaining")
	private int paymentsRemaining;
	@JsonProperty("AccountBalance")
	private double accountBalance;
	@JsonProperty("StatementPreferenceIndicator")
	private String statementPreferenceIndicator;
	@JsonProperty("BorrowerInformation")
	private List<BorrowerInformation> borrowerInformation;
	@JsonProperty("Collateral")
	private List<Collateral> collateral;
	@JsonProperty("PaidToDate")
	private LocalDateTime paidToDate;
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
	private LocalDateTime currentBusinessDate;
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
	private LocalDateTime renewalMaturityDate;
	@JsonProperty("OriginalMaturityDate")
	private LocalDateTime originalMaturityDate;
	@JsonProperty("ExtendedMaturityDate")
	private LocalDateTime extendedMaturityDate;
	@JsonProperty("RepossessionAssignedFlag")
	private String repossessionAssignedFlag;
	@JsonProperty("NextPaymentAmount")
	private double nextPaymentAmount;
	@JsonProperty("LateChargesAmount")
	private double lateChargesAmount;
	@JsonProperty("ExtensionFeeAmount")
	private double extensionFeeAmount;
	@JsonProperty("MiscFeeAmount")
	private double miscFeeAmount;
	@JsonProperty("CreditBalanceAmount")
	private double creditBalanceAmount;
	@JsonProperty("TotalAmountDue")
	private double totalAmountDue;
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
	private String accountExtension;
	
	
	
	
	
	
	
}
