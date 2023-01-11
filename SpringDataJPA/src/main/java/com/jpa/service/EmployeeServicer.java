package com.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpa.controller.Employee;
import com.jpa.repo.EmpolyeeRepo;

@Component
public class EmployeeServicer {
	@Autowired
	EmpolyeeRepo repo;
	
	public Employee addEmployee(Employee e)
	{
		return repo.save(e);
	}

}
