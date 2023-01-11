package com.groovy.pojo;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class SumOfTwonumbers {


	Services services;

	public SumOfTwonumbers(Services services) {
		super();
		this.services = services;
	}

	
	
	
	public int sum(int a, int b) {

		return services.addition(a + b);
	}

	
	
	
	
	public int sum1(int a, int b) {
		if (a + b > 33)
			throw new RuntimeException();
		return a + b;
	}
}
