package com.transform.config;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.transform.controller.Student;

@Configuration
public class IntegrationConfigs {

	@Bean
	@Transformer(inputChannel = "sending.java.to. making.json", outputChannel = "jsonobject")
	public ObjectToJsonTransformer tojson() {
		System.out.println("IntegrationConfigs.tojson()");
		return new ObjectToJsonTransformer(new Jackson2JsonObjectMapper(new ObjectMapper()));
	}

	@Bean
	@Transformer(inputChannel = "sending.json.to. making.object", outputChannel = "javaobject")
	public JsonToObjectTransformer toobject() {
		System.out.println("IntegrationConfigs.toobject()");

		return new JsonToObjectTransformer(Student.class);
	}
}
