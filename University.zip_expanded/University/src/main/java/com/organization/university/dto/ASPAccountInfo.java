package com.organization.university.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
@Entity
@NamedNativeQuery(name = "ASPAccountInfo.getGroundingDetails", query = "select vehicleinfo.model_year,vehicleinfo.brand,vehicleinfo.model,vehicleinfo.ext_color," + 
		" grounding.grounding_date,grounding.odometer_reading, " + 
		" aspinfo.vin,aspinfo.account_type,aspinfo.pay_off_amt,aspinfo.residual_amt, aspinfo.remaining_pmts" + 
		" from  asp.asp_account_info aspinfo, asp.asp_grounding grounding, asp.asp_vehicle_info vehicleinfo WHERE " + 
		" grounding.vin =aspinfo.vin AND " + 
		" grounding.account_number = aspinfo.account_number" + 
		" AND aspinfo.vin = vehicleinfo.vin", resultClass = GroudingDetails.class) 
@NamedNativeQuery(name = "ASPAccountInfo.getAllGroundingDetails", query = "select dealerInfo.dealer_number,dealerInfo.dealer_name,vehicleinfo.model_year,vehicleinfo.brand,vehicleinfo.model,vehicleinfo.ext_color, " + 
		" grounding.grounding_date,grounding.odometer_reading, " + 
		" aspinfo.vin,aspinfo.account_type,aspinfo.pay_off_amt,aspinfo.residual_amt, aspinfo.remaining_pmts, grounding.dealer_action " + 
		" from  asp.asp_account_info aspinfo, asp.asp_grounding grounding, asp.asp_vehicle_info vehicleinfo, asp.asp_dealer_info dealerInfo WHERE " + 
		" grounding.vin =aspinfo.vin AND  grounding.account_number = aspinfo.account_number" + 
		" AND aspinfo.vin = vehicleinfo.vin AND grounding.grounding_dealer_number = dealerInfo.dealer_number", resultClass = GroudingDetails.class)
public class ASPAccountInfo {

	@Id
	private String vin;
	private String accountNumber;
	private LocalDateTime as_of_date;
	private String account_type;
	private String lease_type;
	private String lesse_name;
	private String account_charge_off;
	private String account_repo;
	private LocalDateTime maturity_date;
	private String remaining_pmts;
	private double pay_off_amt;
	private double residual_amt;
	
	
	public double getResidual_amt() {
		return residual_amt;
	}
	public void setResidual_amt(double residual_amt) {
		this.residual_amt = residual_amt;
	}
	private LocalDateTime pay_off_goodthru_date;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public LocalDateTime getAs_of_date() {
		return as_of_date;
	}
	public void setAs_of_date(LocalDateTime as_of_date) {
		this.as_of_date = as_of_date;
	}
	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}
	public String getLease_type() {
		return lease_type;
	}
	public void setLease_type(String lease_type) {
		this.lease_type = lease_type;
	}
	public String getLesse_name() {
		return lesse_name;
	}
	public void setLesse_name(String lesse_name) {
		this.lesse_name = lesse_name;
	}
	public String getAccount_charge_off() {
		return account_charge_off;
	}
	public void setAccount_charge_off(String account_charge_off) {
		this.account_charge_off = account_charge_off;
	}
	public String getAccount_repo() {
		return account_repo;
	}
	public void setAccount_repo(String account_repo) {
		this.account_repo = account_repo;
	}
	public LocalDateTime getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(LocalDateTime maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getRemaining_pmts() {
		return remaining_pmts;
	}
	public void setRemaining_pmts(String remaining_pmts) {
		this.remaining_pmts = remaining_pmts;
	}
	public double getPay_off_amt() {
		return pay_off_amt;
	}
	public void setPay_off_amt(double pay_off_amt) {
		this.pay_off_amt = pay_off_amt;
	}
	public LocalDateTime getPay_off_goodthru_date() {
		return pay_off_goodthru_date;
	}
	public void setPay_off_goodthru_date(LocalDateTime pay_off_goodthru_date) {
		this.pay_off_goodthru_date = pay_off_goodthru_date;
	}
	
		
}
