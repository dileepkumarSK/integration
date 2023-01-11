package com.transform.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.transform.controller.Student;

@MessagingGateway
public interface Gateways {

	@Gateway(requestChannel =  "sending.java.to. making.json")
	Student transform(Student s);
}
