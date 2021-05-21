package com.photo.app.users.shared;

import java.io.Serializable;
import java.util.List;

import com.photo.app.users.model.AlbumResponseModel;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2322496503850813016L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;
	private List<AlbumResponseModel> listAlbums;
	
	
	

	public List<AlbumResponseModel> getListAlbums() {
		return listAlbums;
	}

	public void setListAlbums(List<AlbumResponseModel> listAlbums) {
		this.listAlbums = listAlbums;
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
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
				+ email + ", userId=" + userId + ", encryptedPassword=" + encryptedPassword + ", listAlbums="
				+ listAlbums + "]";
	}

	
	
}
