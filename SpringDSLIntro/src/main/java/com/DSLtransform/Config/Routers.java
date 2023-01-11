package com.DSLtransform.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
public class Routers {

	
	@Bean(name = "to.pubsub.channel")
	public MessageChannel pubsub() {
		return new PublishSubscribeChannel();
	}
	
	
	@Bean(name = "from.gatway.to.route.flow")
	public MessageChannel pub() {
		return new PublishSubscribeChannel();
	}

	@Bean
	public IntegrationFlow route() {
		return IntegrationFlows
				.from("from.gatway.to.route.subflow").route(
						String.class, s -> s.concat("D"), f -> f
								.subFlowMapping("DileepD",
										sub -> sub.transform(String.class, t -> t.concat("transform->Completed"))
												.filter(String.class, inf -> inf.length() > 10).channel("DileepD")))
				.get();

	}

	@Bean
	public IntegrationFlow route1() {
		return IntegrationFlows.from("from.gatway.to.route.flow").<String, String>route(s -> s.concat("D")).get();

	}

	@Bean
	public IntegrationFlow routeFlowByLambda() {
		return IntegrationFlows.from("routerInput").route(String.class, p -> p.length() % 2 == 0 ? "Dileep" : "Hello",
				m -> m.channelMapping("Dileep", "even").channelMapping("Hello", "odd")).get();
	}

	@ServiceActivator(inputChannel = "DileepD")
	// @ServiceActivator(inputChannel ="odd" )
	public String odd(String i) {
		System.err.println(i);
		return i + "kkk";
	}

}
