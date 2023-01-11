package com.transform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringRestRmplateServer2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestRmplateServer2Application.class, args);

	}

	@GetMapping
	public String web() {
		return "Hello sale thu";
	}

}
