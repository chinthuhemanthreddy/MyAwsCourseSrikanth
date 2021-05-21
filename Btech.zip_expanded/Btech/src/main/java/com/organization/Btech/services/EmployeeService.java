package com.organization.Btech.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.organization.Btech.model.Department;
import com.organization.Btech.model.Employee;
import com.organization.Btech.model.EmployeeDetails;
import com.organization.Btech.repo.EmployeeRepository;

@Service
public class EmployeeService {

	
//	  @Autowired
//	  JdbcTemplate jdbcTemplate;
	 
	 @Autowired
	    private EmployeeRepository empRepository;
	 
	 @Value("${grant_type_dev}")
	 private String client_credentials;
	 
	public List<Employee> getEmployeeData() {
		
		/*
		 * Employee e1 = new Employee("Srikanth",10,"CSE"); Employee e2 = new
		 * Employee("Siva",33,"CSE"); Employee e3 = new Employee("Padmaja",25,"CSE");
		 * Employee e4 = new Employee("Bhargavi",7,"CSE"); Employee e5 = new
		 * Employee("eleven",11,"CSE");
		 * 
		 * List<Employee> list = new ArrayList<Employee>(); list.add(e1); list.add(e2);
		 * list.add(e3); list.add(e4); list.add(e5);
		 */
		System.out.println("before calling the database");
		/*
		 * String sql = "SELECT * FROM TestTempEmployee";
		 * System.out.println("before db call"); List<Employee> employee =
		 * jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
		 * System.out.println("after db call"); employee.forEach(System.out :: println);
		 * 
		 */
		
		System.out.println("client_credentials    :::: "+client_credentials);
		
		List<Employee> employee = empRepository.findAll();
		/*
		 * com.organization.Btech.modele.Employee emp = new
		 * com.organization.Btech.modele.Employee(); Employee e = employee.get();
		 * emp.setEmpname(e.getEmpname());
		 */System.out.println("final employee..."+employee);
		
		return employee;
		
	}

	public EmployeeDetails getEmployeeDetails() {
		
		System.out.println("EmployeeDetails service  changes  :::: ");
		EmployeeDetails ed = new EmployeeDetails();
		Department d = new Department();
		d.setActiveEmp(true);
		d.setDeptName("Srikanth");
		d.setEmpName("CSE");
		d.setSalary(10000.986d);
		
		Department d1 = new Department();
		d1.setActiveEmp(true);
		d1.setDeptName("Hemanth");
		d1.setEmpName("IT");
		d1.setSalary(9999.986d);
		
		List<Department> list = new ArrayList<Department>();
		list.add(d);
		list.add(d1);
		ed.setDepartment(list);
		ed.setDeptName("Computers");
		ed.setEmpId(101);
		ed.setEmpName("Head of the Family");
		ed.setJoinDate(LocalDateTime.now());
		
		return ed;
	}

}
