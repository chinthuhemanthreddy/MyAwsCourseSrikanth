package com.organization.Btech.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.organization.Btech.model.Employee;


public interface  EmployeeRepository extends JpaRepository<Employee, Integer> {
	

 	@Modifying
	@Transactional
    @Query(value = "select empid,depname,empname from testtempemployee")
public List<Employee> findDetailsbyId();

}
