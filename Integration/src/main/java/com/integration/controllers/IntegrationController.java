package com.integration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.gateways.IntergrationGateway;

@RestController
@RequestMapping("/hello")
public class IntegrationController {

	@Autowired
	private IntergrationGateway gateway;
	
	@GetMapping(value = "{name}")
	public String getmessagefromintegrateService(@PathVariable String name)
	{
		return gateway.sendMessage(name);
		
	}
}
