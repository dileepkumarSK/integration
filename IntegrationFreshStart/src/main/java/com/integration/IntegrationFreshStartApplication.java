package com.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.messaging.MessageChannel;

import com.integration.classes.Details;
import com.integration.classes.Empolyee;
import com.integration.classes.Student;

@SpringBootApplication
@EnableIntegration
@IntegrationComponentScan
public class IntegrationFreshStartApplication {

	public static void main(String[] args) {
		ApplicationContext ap = SpringApplication.run(IntegrationFreshStartApplication.class);

		//MyhelloService my = ap.getBean(MyhelloService.class);
		

		// MessageChannel ms=ap.getBean("names",MessageChannel.class);

		// Message<String> message = MessageBuilder.withPayload("World").build();
		// ms.send(message);

		// my.sayHello("Dileep");

		/*
		 * MessageChannel channel=ap.getBean("inbound",MessageChannel.class); S
		 * System.out.println(channel.send(message));
		 */

		Details det = ap.getBean(Details.class);
		//det.process("dileep");
		
		
		
		// det.process("Dileep");
		Student st = new Student(10, "Dileep");
		System.err.println(det.process(st).toString() + "Hello");
		System.out.println();
	}

	@Bean
	public MessageChannel names() {
		return new PublishSubscribeChannel();
	}

	@Bean
	public MessageChannel outnames() {
		return new DirectChannel();
	}

	@Bean
	public MessageChannel inbound() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel hello1() {
		return new DirectChannel();
	}

	/*
	 * @ServiceActivator(inputChannel = "requesting.fordet")
	 * 
	 * @Bean public PayloadTypeRouter router() { PayloadTypeRouter router = new
	 * PayloadTypeRouter(); router.setChannelMapping(Student.class.getName(),
	 * "student1"); router.setChannelMapping(Empolyee.class.getName(), "employe");
	 * router.setChannelMapping(String.class.getName(), "dileep"); return router;
	 * 
	 * }
	 */

	//payLoadType
	@Bean
	public IntegrationFlow router1() {
		return IntegrationFlows.from("requesting.fordet").route(routerex()).get();
	}

	public PayloadTypeRouter routerex() {
		PayloadTypeRouter router = new PayloadTypeRouter();
		router.setChannelMapping(Student.class.getName(), "student1");
		router.setChannelMapping(Empolyee.class.getName(), "employe");
		router.setChannelMapping(String.class.getName(), "dileep");
		return router;

	}

//	@Bean
//	public IntegrationFlow routerhe() {
//
//		return IntegrationFlows.from("requesting.fordet").route(routerHeader()).get();
//	}
//
//	public HeaderValueRouter routerHeader() {
//
//		HeaderValueRouter router = new HeaderValueRouter("Which");
//		router.setChannelMapping(Student.class.getName(), "employe");
//		router.setChannelMapping("employe", "employe");
//		router.setChannelMapping(String.class.getName(), "employe");
//		return router;
//
//	}

	/*
	 * @Bean public IntegrationFlow routerList() {
	 * 
	 * return
	 * IntegrationFlows.from("requesting.fordet").route(routerRecipentListRouter()).
	 * get(); }
	 * 
	 * public RecipientListRouter routerRecipentListRouter() {
	 * 
	 * RecipientListRouter router = new RecipientListRouter();
	 * router.addRecipient("student1"); router.addRecipient("employe");
	 * router.addRecipient("dileep"); return router;
	 * 
	 * }
	 */
}
