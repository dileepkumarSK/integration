package com.integration.beans;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
public interface MyhelloService {

	@Gateway(requestChannel = "router")
	public void sayHello(String name);
 }
