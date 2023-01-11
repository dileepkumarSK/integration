package com.integration.gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntergrationGateway {

	@Gateway(requestChannel = "application.integration.gateway.channel")
	public String sendMessage(String message);
}
