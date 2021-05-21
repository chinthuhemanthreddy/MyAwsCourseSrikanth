package com.organization.Btech.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	@JsonProperty("id")
    private int id;
    //@JsonProperty("dateInput")
    private Date createDate;
    
    private LocalDate localtime;
    
	public LocalDate getLocaltime() {
		return localtime;
	}
	public void setLocaltime(LocalDate localtime) {
		this.localtime = localtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		System.out.println("createDate ::: "+createDate);
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", createDate=" + createDate + "]";
	}
    
	
    
}