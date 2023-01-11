package com.integration.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PayloadExample {

	
	@ServiceActivator(inputChannel = "Dileepchannel")
	public void dileep(Message<String> message) {
		System.out.println(message.getPayload() + "Welcom");
	}

	@ServiceActivator(inputChannel = "harichannel")
	public void hari(Message<String> message) {
		System.out.println(message.getPayload() + "Welcom");
	}

	@ServiceActivator(inputChannel = "gouthamchannel")
	public void gowtham(Message<String> message) {
		System.out.println(message.getPayload() + "Welcom");
	}

}
