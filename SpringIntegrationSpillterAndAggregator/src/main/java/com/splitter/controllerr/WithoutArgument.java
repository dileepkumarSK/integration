package com.splitter.controllerr;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.splitter.pojo.Movie;

@MessagingGateway(errorChannel = "error.channel")
public interface WithoutArgument {
	@Gateway(requestChannel = "no.argument.channel",payloadExpression = "new com.splitter.pojo.Movie().hello()")
	String process();
}
