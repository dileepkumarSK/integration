package com.integration.service;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service

public class Routerpractise {

	@ServiceActivator(inputChannel = "newmessage.channel",outputChannel = "")
	public void fromnewmessagechanner(Message<String> me) throws Exception {

		MessageChannel channel = (MessageChannel) me.getHeaders().getReplyChannel();

		System.out.println(me.getClass().toString() + "   ......    class");
		System.out.println(me.getHeaders() + "...........heder");
		System.out.println(me.getPayload());

		channel.send(me);
	}
}
