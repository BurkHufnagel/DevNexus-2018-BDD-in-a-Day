package com.bddinaday.echo.controller

import spock.lang.PendingFeature
import spock.lang.Shared
import spock.lang.Specification

import com.bddinaday.echo.service.EchoService


public class EchoControllerSpec extends Specification {
	
	@Shared
	def controller

	@Shared service
	def setup() {
		controller = new EchoController()
		service = Spy(EchoService, constructorArgs:[])
		controller.echoService = service
	}
		

	def "when called with 'Hello' as the sound it should return 'Hello... hello...'"() {
		when: "'Hello' is passed to the controller"
			def echo = controller.echo("Hello")

		then: "it should return 'Hello... hello...'"
			echo == "Hello... hello..."

		and: "buildEcho should be called just once"
		1 * service.buildEcho(_)
	}
}