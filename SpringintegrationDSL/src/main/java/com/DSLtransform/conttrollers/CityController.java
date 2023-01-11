package com.DSLtransform.conttrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DSLtransform.Gateways.TranfomJavaToXml;
import com.DSLtransform.pojo.City;

@RestController
public class CityController {
	@Autowired
	TranfomJavaToXml javaToXml;

	@GetMapping("/get")
	public Object send(City c) {

		return javaToXml.Transform(c);
	}
	
}
