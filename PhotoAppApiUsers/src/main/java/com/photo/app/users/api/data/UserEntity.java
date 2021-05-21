package com.photo.app.users.api.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="users")
public class UserEntity implements Serializable {


	private static final long serialVersionUID = 3310219037360558606L;

	@Id
	private long id;
	@Column(nullable = false, length= 50)
	private String firstName;
	@Column(nullable = false, length= 50)
	private String lastName;
	
	private String password;
	@Column(nullable = false, length= 120, unique = true)
	private String email;
	@Column(nullable = false, length= 120, unique = true)
	private String userId;
	@Column(nullable = false, length= 120, unique = true)
	private String encryptedPassword;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", email=" + email + ", userId=" + userId + ", encryptedPassword=" + encryptedPassword + "]";
	}
	
	
	
}
