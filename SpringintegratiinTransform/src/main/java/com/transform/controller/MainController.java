package com.transform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.transform.gateways.Gateways;


@Component
public class MainController {
	@Autowired
	Gateways gateways;


	public Student transorm(Student s) {
		return gateways.transform(s);
	}

}
