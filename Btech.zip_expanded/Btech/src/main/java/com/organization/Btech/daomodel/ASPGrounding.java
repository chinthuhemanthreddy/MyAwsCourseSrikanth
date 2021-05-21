package com.organization.Btech.daomodel;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grounding_id")
public class ASPGrounding {

	@Id
	private int vin;
	private String account_number;
	private LocalDate return_date;
	private String returned_by;
	private LocalDate grounding_date;
	private LocalDate ungrounding_date;
	private String ground_dealer_number;
	private String reason_for_return;
	private String odometer_reading;
	private String signed_odometer_statement;
	private String vehicle_drivable;
	private String pickup_location_code;
	private String dealer_action;
	private String tenant_id;
	public int getVin() {
		return vin;
	}
	public void setVin(int vin) {
		this.vin = vin;
	}
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
	public String getReturned_by() {
		return returned_by;
	}
	public void setReturned_by(String returned_by) {
		this.returned_by = returned_by;
	}
	public LocalDate getGrounding_date() {
		return grounding_date;
	}
	public void setGrounding_date(LocalDate grounding_date) {
		this.grounding_date = grounding_date;
	}
	public LocalDate getUngrounding_date() {
		return ungrounding_date;
	}
	public void setUngrounding_date(LocalDate ungrounding_date) {
		this.ungrounding_date = ungrounding_date;
	}
	public String getGround_dealer_number() {
		return ground_dealer_number;
	}
	public void setGround_dealer_number(String ground_dealer_number) {
		this.ground_dealer_number = ground_dealer_number;
	}
	public String getReason_for_return() {
		return reason_for_return;
	}
	public void setReason_for_return(String reason_for_return) {
		this.reason_for_return = reason_for_return;
	}
	public String getOdometer_reading() {
		return odometer_reading;
	}
	public void setOdometer_reading(String odometer_reading) {
		this.odometer_reading = odometer_reading;
	}
	public String getSigned_odometer_statement() {
		return signed_odometer_statement;
	}
	public void setSigned_odometer_statement(String signed_odometer_statement) {
		this.signed_odometer_statement = signed_odometer_statement;
	}
	public String getVehicle_drivable() {
		return vehicle_drivable;
	}
	public void setVehicle_drivable(String vehicle_drivable) {
		this.vehicle_drivable = vehicle_drivable;
	}
	public String getPickup_location_code() {
		return pickup_location_code;
	}
	public void setPickup_location_code(String pickup_location_code) {
		this.pickup_location_code = pickup_location_code;
	}
	public String getDealer_action() {
		return dealer_action;
	}
	public void setDealer_action(String dealer_action) {
		this.dealer_action = dealer_action;
	}
	public String getTenant_id() {
		return tenant_id;
	}
	public void setTenant_id(String tenant_id) {
		this.tenant_id = tenant_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account_number == null) ? 0 : account_number.hashCode());
		result = prime * result + ((dealer_action == null) ? 0 : dealer_action.hashCode());
		result = prime * result + ((ground_dealer_number == null) ? 0 : ground_dealer_number.hashCode());
		result = prime * result + ((grounding_date == null) ? 0 : grounding_date.hashCode());
		result = prime * result + ((odometer_reading == null) ? 0 : odometer_reading.hashCode());
		result = prime * result + ((pickup_location_code == null) ? 0 : pickup_location_code.hashCode());
		result = prime * result + ((reason_for_return == null) ? 0 : reason_for_return.hashCode());
		result = prime * result + ((return_date == null) ? 0 : return_date.hashCode());
		result = prime * result + ((returned_by == null) ? 0 : returned_by.hashCode());
		result = prime * result + ((signed_odometer_statement == null) ? 0 : signed_odometer_statement.hashCode());
		result = prime * result + ((tenant_id == null) ? 0 : tenant_id.hashCode());
		result = prime * result + ((ungrounding_date == null) ? 0 : ungrounding_date.hashCode());
		result = prime * result + ((vehicle_drivable == null) ? 0 : vehicle_drivable.hashCode());
		result = prime * result + vin;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ASPGrounding other = (ASPGrounding) obj;
		if (account_number == null) {
			if (other.account_number != null)
				return false;
		} else if (!account_number.equals(other.account_number))
			return false;
		if (dealer_action == null) {
			if (other.dealer_action != null)
				return false;
		} else if (!dealer_action.equals(other.dealer_action))
			return false;
		if (ground_dealer_number == null) {
			if (other.ground_dealer_number != null)
				return false;
		} else if (!ground_dealer_number.equals(other.ground_dealer_number))
			return false;
		if (grounding_date == null) {
			if (other.grounding_date != null)
				return false;
		} else if (!grounding_date.equals(other.grounding_date))
			return false;
		if (odometer_reading == null) {
			if (other.odometer_reading != null)
				return false;
		} else if (!odometer_reading.equals(other.odometer_reading))
			return false;
		if (pickup_location_code == null) {
			if (other.pickup_location_code != null)
				return false;
		} else if (!pickup_location_code.equals(other.pickup_location_code))
			return false;
		if (reason_for_return == null) {
			if (other.reason_for_return != null)
				return false;
		} else if (!reason_for_return.equals(other.reason_for_return))
			return false;
		if (return_date == null) {
			if (other.return_date != null)
				return false;
		} else if (!return_date.equals(other.return_date))
			return false;
		if (returned_by == null) {
			if (other.returned_by != null)
				return false;
		} else if (!returned_by.equals(other.returned_by))
			return false;
		if (signed_odometer_statement == null) {
			if (other.signed_odometer_statement != null)
				return false;
		} else if (!signed_odometer_statement.equals(other.signed_odometer_statement))
			return false;
		if (tenant_id == null) {
			if (other.tenant_id != null)
				return false;
		} else if (!tenant_id.equals(other.tenant_id))
			return false;
		if (ungrounding_date == null) {
			if (other.ungrounding_date != null)
				return false;
		} else if (!ungrounding_date.equals(other.ungrounding_date))
			return false;
		if (vehicle_drivable == null) {
			if (other.vehicle_drivable != null)
				return false;
		} else if (!vehicle_drivable.equals(other.vehicle_drivable))
			return false;
		if (vin != other.vin)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "  ASPGrounding [vin=" + vin + ", account_number=" + account_number + ", return_date=" + return_date
				+ ", returned_by=" + returned_by + ", grounding_date=" + grounding_date + ", ungrounding_date="
				+ ungrounding_date + ", ground_dealer_number=" + ground_dealer_number + ", reason_for_return="
				+ reason_for_return + ", odometer_reading=" + odometer_reading + ", signed_odometer_statement="
				+ signed_odometer_statement + ", vehicle_drivable=" + vehicle_drivable + ", pickup_location_code="
				+ pickup_location_code + ", dealer_action=" + dealer_action + ", tenant_id=" + tenant_id + "]";
	}
	
	
}

