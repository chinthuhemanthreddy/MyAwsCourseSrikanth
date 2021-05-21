package com.photo.app.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {

	@Size(min=2 , message="first name should not be less than 2 chars...")
	@NotNull(message= "firstname should not be null")
	private String firstName;
	private String lastName;
	@Size(min=2 , max=10, message="password should not be less than 2 chars and greater than 10 chars...")
	private String password;
	@Email
	private String email;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CreateUserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + "]";
	}

	
}
