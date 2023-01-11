package com.integration.classes;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
public interface Details {

	@Gateway(requestChannel = "names")
	Object process(Object ob);
}
