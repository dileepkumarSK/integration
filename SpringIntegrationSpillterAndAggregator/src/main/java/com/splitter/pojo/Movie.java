package com.splitter.pojo;

import java.util.List;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor

public class Movie {

	private String hero;
	private String director;
	private List<MoviesList> mvlist;
	
	public String hello()
	{
		return "hello";
	}
}
