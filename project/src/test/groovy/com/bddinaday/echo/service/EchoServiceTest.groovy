package com.bddinaday.echo.service;

import spock.lang.Specification;

public class EchoServiceTest extends Specification {
	def "when called with 'x' it should return 'x'"() {
		given: "an instance of the EchoService"
			def service = new EchoService()

		when: "the value 'x' is passed to the buildEcho method"
			def echo = service.buildEcho('x')

		then: "it should return 'x'"
			echo == 'x'
	}
}
