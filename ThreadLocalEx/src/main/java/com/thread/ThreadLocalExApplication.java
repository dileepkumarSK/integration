package com.thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThreadLocalExApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ThreadLocalExApplication.class, args);
	
		ThreadLocal< Integer> tl=new ThreadLocal<>();
	
	}

}
