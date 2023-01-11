package com.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.controller.Employee;

public interface EmpolyeeRepo extends JpaRepository<Employee, Integer> {

}
