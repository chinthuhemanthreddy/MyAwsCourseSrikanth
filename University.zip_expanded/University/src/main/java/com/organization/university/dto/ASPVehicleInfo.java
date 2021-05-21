package com.organization.university.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ASPVehicleInfo {
	
	@Id
	private String vin;
	private String brand;
	private String model;
	private String model_number;
	private int model_year;
	private String ext_color;
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getModel_number() {
		return model_number;
	}
	public void setModel_number(String model_number) {
		this.model_number = model_number;
	}
	public int getModel_year() {
		return model_year;
	}
	public void setModel_year(int model_year) {
		this.model_year = model_year;
	}
	public String getExt_color() {
		return ext_color;
	}
	public void setExt_color(String ext_color) {
		this.ext_color = ext_color;
	}
	
	

}
