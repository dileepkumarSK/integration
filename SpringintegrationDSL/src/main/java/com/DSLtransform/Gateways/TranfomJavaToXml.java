package com.DSLtransform.Gateways;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.DSLtransform.pojo.City;

@MessagingGateway
public interface TranfomJavaToXml {

	@Gateway(requestChannel = "java.to.xml")
	Object Transform(City c);
}
