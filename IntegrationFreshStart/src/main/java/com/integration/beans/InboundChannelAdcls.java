package com.integration.beans;

import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


public class InboundChannelAdcls {

	@InboundChannelAdapter(channel = "inbound" ,poller = @Poller(fixedRate =
			"5000"))
	public String hello()
	{
		return "Hello HOw Are You MAN";
	}
	
	@ServiceActivator(inputChannel = "inbound")
	public void hello1(Message<String> message)
	{
		System.out.println(message.getPayload());
	}
}
