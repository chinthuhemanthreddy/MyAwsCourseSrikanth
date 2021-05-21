package com.organization.university.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Collateral {
	@JsonProperty("Year")
	private int year;
	@JsonProperty("Make")
	private String make;
	@JsonProperty("Model")
	private String model;
	@JsonProperty("Style")
	private String style;
	@JsonProperty("NewUsed")
	private String newUsed;
	@JsonProperty("Vin")
	private String vin;
	@JsonProperty("DeliveryMiles")
	private int deliveryMiles;
	@JsonProperty("ContractMiles")
	private int  contractMiles;
	@JsonProperty("FinalMilesLimit")
	private int finalMilesLimit;
	@JsonProperty("ResidualValue")
	private double residualValue;
	@JsonProperty("CustomerIntent")
	private String customerIntent;
	@JsonProperty("LenderStrategy")
	private String lenderStrategy;
	@JsonProperty("ModelDescription")
	private String modelDescription;
	@JsonProperty("ExcessMiles")
	private int excessMiles;
	@JsonProperty("VehicleLicensePlate")
	private String vehicleLicensePlate;
	@JsonProperty("VehicleLicensePlateState")
	private String vehicleLicensePlateState;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getNewUsed() {
		return newUsed;
	}
	public void setNewUsed(String newUsed) {
		this.newUsed = newUsed;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public int getDeliveryMiles() {
		return deliveryMiles;
	}
	public void setDeliveryMiles(int deliveryMiles) {
		this.deliveryMiles = deliveryMiles;
	}
	public int getContractMiles() {
		return contractMiles;
	}
	public void setContractMiles(int contractMiles) {
		this.contractMiles = contractMiles;
	}
	public int getFinalMilesLimit() {
		return finalMilesLimit;
	}
	public void setFinalMilesLimit(int finalMilesLimit) {
		this.finalMilesLimit = finalMilesLimit;
	}
	public double getResidualValue() {
		return residualValue;
	}
	public void setResidualValue(double residualValue) {
		this.residualValue = residualValue;
	}
	public String getCustomerIntent() {
		return customerIntent;
	}
	public void setCustomerIntent(String customerIntent) {
		this.customerIntent = customerIntent;
	}
	public String getLenderStrategy() {
		return lenderStrategy;
	}
	public void setLenderStrategy(String lenderStrategy) {
		this.lenderStrategy = lenderStrategy;
	}
	public String getModelDescription() {
		return modelDescription;
	}
	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}
	public int getExcessMiles() {
		return excessMiles;
	}
	public void setExcessMiles(int excessMiles) {
		this.excessMiles = excessMiles;
	}
	public String getVehicleLicensePlate() {
		return vehicleLicensePlate;
	}
	public void setVehicleLicensePlate(String vehicleLicensePlate) {
		this.vehicleLicensePlate = vehicleLicensePlate;
	}
	public String getVehicleLicensePlateState() {
		return vehicleLicensePlateState;
	}
	public void setVehicleLicensePlateState(String vehicleLicensePlateState) {
		this.vehicleLicensePlateState = vehicleLicensePlateState;
	}

	
	
}
