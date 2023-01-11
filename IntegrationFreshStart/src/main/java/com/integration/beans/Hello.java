package com.integration.beans;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

import com.integration.classes.Student;

@Configuration
public class Hello 
{
	
	/*//PubSub==>> 
	 * @ServiceActivator(inputChannel = "names") public void mymethod2(String name)
	 * { System.out.println("Hello.mymethod2()"); System.out.println("hello "+name);
	 * }
	 * 
	 * @ServiceActivator(inputChannel = "names") public void mymethod1(String name)
	 * { System.out.println("Hello.mymethod1()"); System.out.println("hello "+name);
	 * }
	 */ 
	 
	 
	
	
	/*
	 * @Autowired
	 * 
	 * @Qualifier("outnames")MessageChannel channel;
	 */
	/*
	 * @ServiceActivator( inputChannel = "names",outputChannel = "outnames") public
	 * Message<String> sayHello(Message<String> name) {
	 * 
	 * System.out.println("Hello.sayHello()");
	 * 
	 * 
	 * Message< String> m=MessageBuilder.withPayload(name.getPayload()).build();
	 * 
	 * 
	 * // System.out.println(ServiceActivator.class.); return m;
	 * 
	 * }
	 */
	
     @ServiceActivator(inputChannel = "outnames")
     public void outchanee(String name)
     {
    	 System.out.println("Hello.outchanee()");
    	 System.out.println("hello "+name);
     }
	
     
     
		/*
		 * @ServiceActivator(inputChannel = "names" ,outputChannel =
		 * "requesting.fordet") public Message<Object> sayHello(Message<Object> name) {
		 * 
		 * System.out.println("Hello.sayHello()"); Student st= (Student)
		 * name.getPayload(); Message<Object> newmes=
		 * MessageBuilder.withPayload(name.getPayload()).setHeader("Which",
		 * st.getClass().getName()).build(); System.out.println("hello"); return newmes;
		 * }
		 */
     
     
     
     
     @ServiceActivator(inputChannel =  "names" ,outputChannel = "requesting.fordet")
     public Message<Object> sayHello(Message<Object> name) {
 		
 		System.err.println("Hello.sayHello()");
 		System.err.println(name.getPayload());
 		
 		return name;
 	}
     
     
     
     
}
