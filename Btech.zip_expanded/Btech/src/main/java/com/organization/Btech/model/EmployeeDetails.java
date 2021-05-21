package com.organization.Btech.model;

import java.time.LocalDateTime;
import java.util.List;

public class EmployeeDetails {

	private String empName;
	private String deptName;
	private int empId;
	private List<Department> department;
	private LocalDateTime joinDate;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public List<Department> getDepartment() {
		return department;
	}
	public void setDepartment(List<Department> department) {
		this.department = department;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
