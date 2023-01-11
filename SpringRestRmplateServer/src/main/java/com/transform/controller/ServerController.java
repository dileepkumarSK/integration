package com.transform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class ServerController {

	@Autowired
	RestTemplate restTemplate;

//	@GetMapping
//	public ResponseEntity<?> get()
//	{
//		ResponseEntity< Object> obj=restTemplate.getForEntity("http://localhost:1234/get", Object.class);
//		System.out.println(obj);
//		return obj;
//	}
	@GetMapping
	public void get() {
		WebClient web = WebClient.create();
		System.out.println("hello");
		// Student obj =
		// web.get().uri("http://localhost:1234/get").retrieve().bodyToMono(Student.class).block();
		web.get().uri("http://localhost:1234/get").retrieve().bodyToMono(Student.class)
				.subscribe(ServerController::getfromsubscrbe);
		web.get().uri("http://localhost:1996").retrieve().bodyToMono(String.class)
				.subscribe(ServerController::getfromsubscrbe);

		System.out.println("hellojjj");
		// System.out.println(obj);
		System.out.println("hellojjj");
		System.out.println("hellojjj");

	}

	public static void getfromsubscrbe(Student s) {
		System.out.println(s);
	}
	
	public static void getfromsubscrbe(String s) {
		System.out.println(s);
	}
}
