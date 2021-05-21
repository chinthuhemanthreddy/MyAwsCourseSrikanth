package com.organization.Btech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "testtempemployee")
public class Employee {

	  
	


	
	@Column(name = "empname")
	private String empname;
	@Id
	@Column(name = "empid")
	private int empid;

	@Column(name = "deptname")
	private String depname;
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((depname == null) ? 0 : depname.hashCode());
		result = prime * result + empid;
		result = prime * result + ((empname == null) ? 0 : empname.hashCode());
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
		Employee other = (Employee) obj;
		if (depname == null) {
			if (other.depname != null)
				return false;
		} else if (!depname.equals(other.depname))
			return false;
		if (empid != other.empid)
			return false;
		if (empname == null) {
			if (other.empname != null)
				return false;
		} else if (!empname.equals(other.empname))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empid=" + empid + ", depname=" + depname + "]";
	}



	public String getEmpname() {
		return empname;
	}



	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public int getEmpid() {
		return empid;
	}



	public void setEmpid(int empid) {
		this.empid = empid;
	}



	public String getDepname() {
		return depname;
	}



	public void setDepname(String depname) {
		this.depname = depname;
	}



	
	

}
