package com.transform.contoller;




import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transform.pojo.Student;

@RestController
public class ClientContorller {

	@GetMapping(value="/get",produces = {MediaType.APPLICATION_JSON_VALUE})
	public Student getDetails()
	{
		return new Student(123,"dileep");
	}
	@GetMapping
	public String home() 
	{
		return "home";
		
	}
	
	
	
	
}
