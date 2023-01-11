package com.integration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class ServiceActivators {

	@ServiceActivator(inputChannel = "message")
	public void messagefromservce(Message<String> message) throws MessagingException {

		System.out.println(message.getClass().toString()+"   ......    class");
		System.out.println(message.getHeaders()+"...........heder");
		System.out.println(message.getPayload());

		

		Message<String> newmessage = MessageBuilder
				.withPayload("welcome" + message.getPayload() + " to spring integrtaion").build();

		//replychannel.send(newmessage);
		PayloadTypeRouter router=new PayloadTypeRouter();
		router.setChannelMapping(newmessage.toString(), "newmessage.channel");
		
	}

}
