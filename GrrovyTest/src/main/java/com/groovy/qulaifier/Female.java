package com.groovy.qulaifier;

import org.springframework.stereotype.Component;

@Component
public class Female implements Population {

	@Override
	public void eligible() {
		System.out.println("Female.eligible()");
	}

}
