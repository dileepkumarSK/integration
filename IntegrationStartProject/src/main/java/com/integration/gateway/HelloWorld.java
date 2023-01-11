package com.integration.gateway;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface HelloWorld {

	/*
	 * @Gateway(requestChannel = "message") String sayhello(String s);
	 */

	@Gateway(requestChannel = "message")
	
	String hello(String m);

}
