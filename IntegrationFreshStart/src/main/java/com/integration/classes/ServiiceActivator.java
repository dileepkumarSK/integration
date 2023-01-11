package com.integration.classes;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.json.JsonToObjectTransformer;
import org.springframework.integration.json.ObjectToJsonTransformer;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.json.Jackson2JsonObjectMapper;
import org.springframework.integration.support.json.JsonObjectMapper;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ServiiceActivator {

	@ServiceActivator(inputChannel = "ss")
	public void students(Message<Student> std) {
		Student s = std.getPayload();

		System.out.println("ServiiceActivator.student()  " + s);
	}

	@ServiceActivator(inputChannel = "employe")
	public void employee() {
		System.out.println("ServiiceActivator.employee()");
	}

	@Filter(inputChannel = "student1", outputChannel = "hello1", throwExceptionOnRejection = "true")
	public boolean dileep(Message<Student> std) {

		System.out.println("dIleep " + std.getPayload() + "    Endpoint oF input  filter");
		if (!std.equals(null)) {
			return true;
		}

		return false;

	}

	@Bean
	@Transformer(inputChannel = "hello1", outputChannel = "json")
	public ObjectToJsonTransformer transoorming() {
		System.out.println("ServiiceActivator.transoorming()");
		System.out.println();
		System.out.println();
		return new ObjectToJsonTransformer(new Jackson2JsonObjectMapper(new ObjectMapper()));

	}

	@ServiceActivator(inputChannel = "json", outputChannel = "java")
	public Object jsonshowing(Message<Object> obj) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(obj.getPayload().toString());
		System.out.println();
		System.out.println();
		System.out.println();
		return obj;
	}

	@Bean
	@Transformer(inputChannel = "java", outputChannel = "convert")
	public JsonToObjectTransformer javaobj() {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		return new JsonToObjectTransformer(Student.class);
	}

	@ServiceActivator(inputChannel = "convert")
	public Object javashowing(Message<Object> obj) {
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("ServiiceActivator.javashowing()");
		System.out.println(obj.getPayload().toString());
		System.out.println();
		System.out.println();
		System.out.println();
		return obj;
	}

}
