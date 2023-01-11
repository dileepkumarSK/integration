package com.splitter;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Splitter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.integration.splitter.MethodInvokingSplitter;
import org.springframework.messaging.MessageChannel;

import com.splitter.controllerr.WithoutArgument;
import com.splitter.gateway.MovieSplitter;



@SpringBootApplication

public class SpringIntegrationSpillterAndAggregatorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringIntegrationSpillterAndAggregatorApplication.class, args);
		
		WithoutArgument wt=ctx.getBean(WithoutArgument.class);
		System.out.println(wt.process()+" hellohi ");
		
		
	}

//	@Splitter
//	@Bean
//	public AbstractMessageSplitter spiltter() {
//		return new MethodInvokingSplitter(messageModifier(), "splitter").setOutputChannel(ms());
//	}
	
	@Bean
	public MessageChannel ms()
	{
		return new DirectChannel();
	}
	
	@Bean
	public MessageModifier messageModifier()
	{
		return new MessageModifier();
	}
	
	
	
	
	
	
	

}
class MessageModifier {
	public Collection<Object> splitter() {
		return new ArrayList<>();
	}
}