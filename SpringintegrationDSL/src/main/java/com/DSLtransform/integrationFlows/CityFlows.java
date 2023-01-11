package com.DSLtransform.integrationFlows;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.messaging.Message;

import com.DSLtransform.pojo.City;

@Configuration
public class CityFlows {

	public CityFlows() {
		super();
		// TODO Auto-generated constructor stub
	}

//	
	/*public IntegrationFlow flow() {
		return IntegrationFlows.from("java.to.xml").transform();
		
	}
*/
/*
 * private static Object convertObjectToXML(City city) throws JAXBException{ //
 * create JAXB context and instantiate marshaller JAXBContext context =
 * JAXBContext.newInstance(City.class); Marshaller m =
 * context.createMarshaller(); m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
 * Boolean.TRUE); m.marshal(m,); return m; } 
 */}
