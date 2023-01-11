package com.integration.classes;

import com.integration.interfaces.HelloWorld;

public class Sayhello implements HelloWorld {

	@Override
	public void messeage() {
		System.out.println("Sayhello.messeage()");
	}

}	
