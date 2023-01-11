package com.splitter.serviceActivator;

import java.sql.SQLSyntaxErrorException;
import java.util.logging.Logger;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class ServiceActoivators {

	Logger log=Logger.getLogger("hello");
	@ServiceActivator(inputChannel = "no.argument.channel")
	public void hello(Message<?> message)
	{
	System.err.println(message.getPayload().toString());
		
	    throw new RuntimeException("ForSimplythrowing");
//		MessageChannel ry=(MessageChannel) message.getHeaders().getReplyChannel();
//		
//		ry.send(message);
	}
	
	
	@ServiceActivator(inputChannel = "error.channel")
	public void Excpetion(Message<RuntimeException> excetion)
	{
		System.err.println("exception casue"+excetion.getPayload().getMessage());
	}
}
