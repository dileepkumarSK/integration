package com.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.RestController;

import com.integration.gateway.HelloWorld;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class IntegrationStartProjectApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(IntegrationStartProjectApplication.class, args);
		HelloWorld hello = ctx.getBean(HelloWorld.class);
		System.out.println(hello.hello("Dileep"));

	}

	@Bean
	public MessageChannel message() {
		DirectChannel dd = new DirectChannel();
		return new DirectChannel();
	}

}
