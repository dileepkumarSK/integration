package com.transform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.integration.config.EnableIntegration;

import com.transform.controller.MainController;
import com.transform.controller.Student;

@SpringBootApplication
@EnableIntegration
public class SpringintegratiinTransformApplication {

	public static void main(String[] args) {
		ApplicationContext ap=SpringApplication.run(SpringintegratiinTransformApplication.class, args);
		System.out.println(ap.getBean(MainController.class).transorm(new Student("Dileep", 13)));
	}

}
