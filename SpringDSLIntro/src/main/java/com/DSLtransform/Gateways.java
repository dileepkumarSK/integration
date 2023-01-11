package com.DSLtransform;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway
public interface Gateways {

	//@Gateway(requestChannel = "input",requestTimeout =  5000)
	String execute(String g,@Header(value = "Dileep") String name,@Header(value = "hh",required = false) int s);
	
	@Gateway(requestChannel = "input")
	String ChannelExcuestion(String s);
	
	@Gateway(requestChannel = "from.gatway.to.route.flow")
	String toroute(String s);
	
	@Gateway(requestChannel = "from.gatway.to.route.subflow")
	String toroutesub(String s);
	
	@Gateway(requestChannel = "routerInput")  
	String sending(String i);
	
	@Gateway(requestChannel = "recipientListInput")
	Integer recipientList(String s);
	
	
	@Gateway(requestChannel = "forhandler")
	Integer handler(String s);
	
	@Gateway(requestChannel = "to.pubsub.channel")
	void topubsub(Integer n);
}
