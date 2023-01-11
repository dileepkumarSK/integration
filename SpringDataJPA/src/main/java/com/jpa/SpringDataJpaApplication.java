package com.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.controller.Employee;
import com.jpa.service.EmployeeServicer;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		EmployeeServicer ser = context.getBean(EmployeeServicer.class);
		System.out.println(ser.addEmployee(new Employee("Dileep", 12)));
	}

}
