package com.DSLtransform.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
public class Handlers {

	/*
	 * @Bean public IntegrationFlow flow() { return
	 * IntegrationFlows.from("forhandler").handle(String.class,(p,h)->
	 * Integer.parseInt(p)*2).get(); }
	 */

	@Bean
	public IntegrationFlow flow1() {
		return IntegrationFlows.from("forhandler").handle(String.class, (p, h) -> Integer.parseInt(p) * 2)
				.handle((x, y) -> {
					System.err.println(x);
					return x;
				}).channel("from.handlerto.serviceactivator").get();
	}

	@ServiceActivator(inputChannel = "from.handlerto.serviceactivator")
	public void fromhandler(Message<?> m) {
		 MessageChannel  channel=  (MessageChannel) m.getHeaders().getReplyChannel();
		 channel.send(m);
	}

}
