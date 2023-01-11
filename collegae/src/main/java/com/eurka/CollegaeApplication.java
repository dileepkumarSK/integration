package com.eurka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CollegaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegaeApplication.class, args);
	}

}
