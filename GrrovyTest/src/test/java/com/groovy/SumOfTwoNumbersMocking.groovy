package com.groovy

import com.groovy.pojo.Services
import com.groovy.pojo.SumOfTwonumbers

import spock.lang.*;

class SumOfTwoNumbersMocking extends Specification {

	def service=Stub(Services)
	def sum=new SumOfTwonumbers(service)

	def "mockimg test"(){	
			
		given:
		def a=1
		def b=2
		
		service.addition(a+b) >> 103

		when:
		def s=sum.sum(a, b);
		then:
		s==103
	}
}
