package com.organization.Btech.contollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.organization.Btech.model.Employee;
import com.organization.Btech.model.EmployeeDetails;
import com.organization.Btech.model.User;
import com.organization.Btech.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired(required=true)
	EmployeeService empService;
	
	@RequestMapping("/employeesData")
    public List<Employee> getEmployeeData(@RequestBody String payload) throws Exception {
		System.out.println("university getEmployeeData contorller  ::: "+payload);
		try {
		int i =10;
		int j = i/0;
		}catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("in contoller ae exception...");
			throw new Exception();
		}
		System.out.println("after arthematic exception.......");
		List<Employee>  employees =	empService.getEmployeeData();
        return employees;
    }
	
	@PostMapping("/employeesDetails")
    public String getEmployeeDetails(@RequestBody User dateInput) {
		System.out.println("getEmployeeDetails contorller "+dateInput);
		//DateInput d = new DateInput();
		//d.setDateOfString(dateInput);
		//System.out.println("-->"+d.getDateOfString());
        return "Srikanth " +dateInput.getCreateDate() ;
    }
	
	@PostMapping("/dateUpdate")
    public EmployeeDetails udateAccount(@RequestBody String payload) {
		System.out.println("getEmployeeDetails contorller");
		EmployeeDetails employeeDetails=	empService.getEmployeeDetails();
        return employeeDetails;
    }
	
	 @PostMapping("/users/{userId}")
	 public String getUsers(@PathVariable String userId,@RequestBody String payload) {
		 System.out.println("flksdjflksakdfhlsad ::::: ");
		 System.out.println("payload ::: "+payload);
		 return userId;
	 }
	 
	 @GetMapping("/usersparam")
	 public String getUsers(@RequestParam(value = "name", defaultValue = "fuck") String name) {
		 System.out.println("flksdjflksakdfhlsad ::::: ");
		 System.out.println("payload ::: "+name);
		 return name;
	 }
	
	
}
