package com.groovy.qulaifier;

import org.springframework.stereotype.Component;

@Component
public class Male implements Population{

	@Override
	public void eligible() {
		System.out.println("Male.eligible()");		
	}

}
