package com.organization.university.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import lombok.Data;
@Entity
@NamedNativeQuery(name = "ASPGroundDetails.getGroundingDetails", query = "select vehicleinfo.model_year,vehicleinfo.brand,vehicleinfo.model,vehicleinfo.ext_color," + 
		" grounding.grounding_date,grounding.odometer_reading,  grounding.vin," + 
		" aspinfo.account_type,aspinfo.pay_off_amt,aspinfo.residual_amt, aspinfo.remaining_pmts" + 
		" from  asp.asp_account_info aspinfo, asp.asp_grounding grounding, asp.asp_vehicle_info vehicleinfo WHERE " + 
		" grounding.vin =aspinfo.vin AND " + 
		" grounding.account_number = aspinfo.account_number" + 
		" AND aspinfo.vin = vehicleinfo.vin", resultClass = GroudingDetails.class) 
public class ASPGroundDetails {
	

	@Id
	private String account_type;
	private int pay_off_amt;
	private int residual_amt;
	private int remaining_pmts;

}
