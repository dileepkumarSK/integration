package com.transform.services;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class ServicesActivators {

	@ServiceActivator(inputChannel = "jsonobject",outputChannel = "sending.json.to. making.object")
	public Message<?> jsontransor(Message<?> message) {
		System.out.println("json===============>>.>>>");
		System.out.println(message.getPayload());
		System.out.println(message.getHeaders().getReplyChannel());
	
		return message;
	}

	@ServiceActivator(inputChannel = "javaobject")
	public Message<?> javatransor(Message<?> message) {
		System.out.println(message.getPayload());
		System.out.println(message.getHeaders().getReplyChannel());
		return message;
	}
}
