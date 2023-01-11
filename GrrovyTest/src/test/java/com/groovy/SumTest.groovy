package com.groovy

import com.groovy.pojo.SumOfTwonumbers

import spock.lang.*;

class SumTest extends Specification {

	def clsobj=new SumOfTwonumbers();
	def "sum testing"(){

		given:
		def  a=10
		def b=220
		when:
		clsobj.sum1(a, b)
		then:
		thrown(RuntimeException)
	/*	when:
		def su=clsobj.sum1(a, b)
		then:
		su==30*/
	}
}
