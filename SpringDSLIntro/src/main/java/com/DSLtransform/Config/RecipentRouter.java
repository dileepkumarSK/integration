package com.DSLtransform.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;

@Configuration
public class RecipentRouter {

	@Bean
	public IntegrationFlow recipientListFlow() {
		return IntegrationFlows.from("recipientListInput")
				.transform(String.class, p -> Integer.parseInt(p) + 200)
				.routeToRecipients(r -> 
				r.recipient("firstrecipient")
					.recipient("secongrecipient")
					.recipient("thirdrecipient")
					.recipientFlow(r1 -> 
						r1.filter(Integer.class, in -> in > 100))
								.recipient("fourthchannel"))
				.get();
	}

	@ServiceActivator(inputChannel = "firstrecipient")
	public void firstrecipient(Message<Integer> m) {
		System.out.println("RecipentRouter.firstrecipient()");
		System.out.println(m.getPayload()+10);
	}
	

	@ServiceActivator(inputChannel = "secongrecipient")
	public void secongrecipient(Message<Integer> m) {
		System.out.println("RecipentRouter.secongrecipient()");
		System.out.println(m.getPayload()+1);
	}
	

	@ServiceActivator(inputChannel = "thirdrecipient")
	public void thirdrecipient(Message<Integer> m) {
		System.out.println("RecipentRouter.thirdrecipient()");
		System.out.println(m.getPayload()+2);
	}
	

	@ServiceActivator(inputChannel = "fourthchannel")
	public void fourthchannel(Message<Integer> m) {
		System.out.println("RecipentRouter.fourthchannel()");
		System.out.println(m.getPayload()+3);
	}
	
	

}
