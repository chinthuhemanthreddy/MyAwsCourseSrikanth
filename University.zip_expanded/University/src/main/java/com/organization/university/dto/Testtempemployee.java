package com.organization.university.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "testtempemployee")
public class Testtempemployee {
	@Id
	private int empid;
	private String depname;
	private String empname;
	private String encrypted_password;
	private String first_name;
	private String user_id;
	private String last_name;
}
