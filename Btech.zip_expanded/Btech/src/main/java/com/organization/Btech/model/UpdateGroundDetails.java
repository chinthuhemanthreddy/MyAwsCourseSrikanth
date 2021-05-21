package com.organization.Btech.model;

import java.time.LocalDate;

public class UpdateGroundDetails {

	private String account_number;
	private LocalDate 	return_date;
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	@Override
	public String toString() {
		return "UpdateGroundDetails [account_number=" + account_number + ", return_date=" + return_date + "]";
	}
	
	
	
}
