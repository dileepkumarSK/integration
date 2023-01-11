package com.DSLtransform.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

//@Configuration
public class Configs {
	
	  //noramal
	  
	  @Bean public IntegrationFlow upcaseFlow() {
		  return IntegrationFlows.from("input")
				  .transform(this::toUppercase)
				  .filter(this::check).route(this::route)
				  .channel("dileep") .get();
	  
	  }
	 

	/*
	 * @Bean public IntegrationFlow onlyChannels() { return
	 * IntegrationFlows.from("input") .fixedSubscriberChannel()
	 * .channel("queueChannel") .channel(publishSubscribe())
	 * .channel("output").get(); }
	 * 
	 * @Bean public MessageChannel queueChannel() { return new QueueChannel(); }
	 * 
	 * @Bean public MessageChannel publishSubscribe() { return new
	 * PublishSubscribeChannel(); }
	 * 
	 * 
	 * 
	 */

	

	/*
	 * public IntegrationFlow upcaseFlow() { return
	 * IntegrationFlows.from("input").<String,
	 * Integer>transform(Configs::toUppercase)
	 * .<Integer>filter(Configs::check).channel("dileep").<Integer,
	 * PayloadTypeRouter>route(i->{ PayloadTypeRouter py = new PayloadTypeRouter();
	 * py.setChannelMapping(Integer.class.toString(), "dileep"); return py;
	 * 
	 * }) .get();
	 */

	
	
	
	
//	@ServiceActivator(inputChannel = "input")
//	public void meth1() {
//		System.out.println("hi");
//		
//	}
	
	
	
	
	
	
	@ServiceActivator(inputChannel = "dileep")
	public Integer print(Message<Integer> i) {
		MessageChannels.queue().get();
		System.err.println(i.getPayload());
		System.err.println(i.getHeaders());
		return i.getPayload();
	}

	public Integer toUppercase(String s) {

		return Integer.parseInt(s) + 110;
	}

	public boolean check(Integer i) {
		System.err.println("Configs.check()");
		return i > 100;
	}

	public PayloadTypeRouter route(Integer i) {
		System.out.println("Configs.route()");
		PayloadTypeRouter py = new PayloadTypeRouter();
		py.setChannelMapping(Integer.class.toString(), "dileep");
		return py;

	}

	
	
	@Bean
	public IntegrationFlow routeFlowByLambda() {
	return IntegrationFlows.from("routerInput")
	.<Integer, Boolean>route(p -> p % 2 == 0,
	m -> m.suffix("Channel")
	.channelMapping(true, "even")
	.channelMapping(false, "odd")
	)
	.get();
	}
	
	
	
}
