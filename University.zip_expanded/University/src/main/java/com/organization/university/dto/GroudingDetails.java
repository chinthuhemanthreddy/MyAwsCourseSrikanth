package com.organization.university.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties({"pay_off_amt","residual_amt"})
//@JsonInclude(value = Include.NON_NULL  )
@JsonInclude(value = Include.NON_EMPTY)
public class GroudingDetails {

	//asp_account_info table 
	private String account_type;
	private int pay_off_amt;
	@JsonIgnoreProperties
	private int residual_amt;
	private int remaining_pmts;
	//asp_vehicle_info table
	private int model_year;
	private  String brand;
	private String model;
	private String ext_color;
	//asp_grounding table
	private LocalDateTime grounding_date;
	private String odometer_reading;
	@Id
	private String vin;
	
	private String dealer_action;
	
}
