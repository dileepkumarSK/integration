package com.integration.gateways;

import java.io.Serial;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class ServiceClass {
	
	@ServiceActivator(inputChannel = "application.integration.gateway.channel")

	public void messagefromservce(Message<String> message) throws MessagingException {
		MessageChannel replychannel = (MessageChannel) message.getHeaders().getReplyChannel();
		MessageBuilder.fromMessage(message);
		Message<String> newmessage = MessageBuilder
				.withPayload("welcome" + message.getPayload() + " to spring integrtaion").build();

		replychannel.send(newmessage);
	}
}
