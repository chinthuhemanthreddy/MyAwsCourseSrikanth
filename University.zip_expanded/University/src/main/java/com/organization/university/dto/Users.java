package com.organization.university.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {

	@Id
	private int id;
	private String email;
	private String encrypted_password;
	private String first_name;
	private String last_name;
	private String password;
	private String user_id;
	
}
