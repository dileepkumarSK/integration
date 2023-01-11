package com.groovy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.groovy.qulaifier.Male;
import com.groovy.qulaifier.Population;

@SpringBootApplication
public class GrrovyTestApplication {

	public static void main(String[] args) {
		ApplicationContext ap=SpringApplication.run(GrrovyTestApplication.class, args);
		Population p= ap.getBean(Population.class);
		p.eligible();
	}

}
