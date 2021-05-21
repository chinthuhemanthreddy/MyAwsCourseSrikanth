package com.organization.university.dto;

import java.util.List;


public class ASPAccountInfoAndVehicleInfo {

private List<ASPAccountInfo> accountInfo;
	
	private List<ASPVehicleInfo> vehicleInfo;

	public List<ASPAccountInfo> getAccountInfo() {
		return accountInfo;
	}

	public void setAccountInfo(List<ASPAccountInfo> accountInfo) {
		this.accountInfo = accountInfo;
	}

	public List<ASPVehicleInfo> getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(List<ASPVehicleInfo> vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}
	
	
	
}
