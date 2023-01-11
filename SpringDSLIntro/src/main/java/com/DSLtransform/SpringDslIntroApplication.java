package com.DSLtransform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDslIntroApplication {

	public static void main(String[] args) {
		ApplicationContext conext = SpringApplication.run(SpringDslIntroApplication.class, args);
		
		//System.out.println(conext.getBean(Gateways.class).execute("190","hhhh",9));
		
		//System.out.println(conext.getBean(Gateways.class).ChannelExcuestion("Dileep"));
		
	//	System.out.println(conext.getBean(Gateways.class).toroute("Dileep"));
		
		//System.out.println(conext.getBean(Gateways.class).sending("jj "));

			//System.out.println(conext.getBean(Gateways.class).recipientList("188"));
	
		//System.out.println(conext.getBean(Gateways.class).handler("188")+" hello");

		
	//	System.out.println(conext.getBean(Gateways.class).toroutesub("Dileep"));

	
		
		conext.getBean(Gateways.class).topubsub(4);

	}

}
