package com.DSLtransform.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.messaging.Message;

@Configuration
public class PubSubFlows {
	@Bean
	public IntegrationFlow pubSubFlowsflow() {
		return f -> f.channel("to.pubsub.channel").split().log(LoggingHandler.Level.INFO, "pubsubflow1")
				.publishSubscribeChannel(
						m -> m.subscribe(s -> s.channel("pubsubflow1")).subscribe(f2 -> f2.channel("pubsubflow2"))
								.subscribe(f2 -> f2.channel("pubsubflow3")).subscribe(f2 -> f2.channel("pubsubflow4")));
	}

	@Bean
	public IntegrationFlow pubSubFlowspubsubflow1() {
		return IntegrationFlows.from("pubsubflow1").log(LoggingHandler.Level.INFO, "pubsubflow1")
				.filter(Integer.class, n -> n < 10 && n > 1)
				.log(LoggingHandler.Level.INFO, "pubsubflow1 filter completd")
				.transform(Integer.class, n -> String.valueOf(n).concat(" from flow One i recived"))
				.log(LoggingHandler.Level.INFO, "pubsubflow1 transform Completed").channel("output").get();
	}

	@Bean
	public IntegrationFlow pubSubFlowspubsubflow2() {
		return IntegrationFlows.from("pubsubflow2").log(LoggingHandler.Level.INFO, "pubsubflow2")
				.filter(Integer.class, n -> n > 10 && n <= 1)
				.log(LoggingHandler.Level.INFO, "pubsubflow2 filter completd")
				.transform(Integer.class, n -> String.valueOf(n).concat(" from flow two i recived"))
				.log(LoggingHandler.Level.INFO, "pubsubflow1 transform Completed").channel("output").get();
	}

	@Bean
	public IntegrationFlow pubSubFlowspubsubflow3() {
		return IntegrationFlows.from("pubsubflow3").log(LoggingHandler.Level.INFO, "pubsubflow3")
				.filter(Integer.class, n -> n < 33 && n <= 1)
				.log(LoggingHandler.Level.INFO, "pubsubflow3 filter completd")
				.transform(Integer.class, n -> String.valueOf(n).concat(" from flow three i recived"))
				.log(LoggingHandler.Level.INFO, "pubsubflow3 transform Completed").channel("output").get();
	}

	@Bean
	public IntegrationFlow pubSubFlowspubsubflow4() {
		return IntegrationFlows.from("pubsubflow4").log(LoggingHandler.Level.INFO, "pubsubflow4")
				.filter(Integer.class, n -> n < 100 && n <= 80)
				.log(LoggingHandler.Level.INFO, "pubsubflow4 filter completd")
				.transform(Integer.class, n -> String.valueOf(n).concat(" from flow One i recived"))
				.log(LoggingHandler.Level.INFO, "pubsubflow4 transform Completed").channel("output").get();
	}

	@ServiceActivator(inputChannel = "output")
	public void output(Message<String> message) {
		System.err.println(message.getPayload());
	}

	/*
	 * @ServiceActivator(inputChannel = "output2") public void
	 * output2(Message<String> message) { System.err.println(message.getPayload());
	 * }
	 * 
	 * @ServiceActivator(inputChannel = "output3") public void
	 * output3(Message<String> message) { System.err.println(message.getPayload());
	 * }
	 * 
	 * @ServiceActivator(inputChannel = "output4") public void
	 * output4(Message<String> message) { System.err.println(message.getPayload());
	 * }
	 */
}
