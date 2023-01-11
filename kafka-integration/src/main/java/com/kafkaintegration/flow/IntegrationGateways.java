package com.kafkaintegration.flow;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateways {
    @Gateway(requestChannel = "dataSendToKafka")
	String send(String s);
}
