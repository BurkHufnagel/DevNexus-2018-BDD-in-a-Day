package com.bddinaday.echo.service

import spock.lang.PendingFeature
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


public class EchoServiceSpec extends Specification {
	@Shared
	def service = new EchoService()


	def "when called with 'Hello' as the sound it should return 'Hello... hello...'"() {
		when: "'Hello' is passed to the service"
			def echo = service.buildEcho("Hello")

		then: "the echo should be 'Hello... hello...'"
			echo == "Hello... hello..."
	}
	
	
	def "when called with an empty String then it should return '...'"() {
		when: "an empty String is passed to the service"
			def echo = service.buildEcho("")

		then: "the echo should be '...'"
			echo == "..."
	}
	
	
	@Unroll
	def "when called with #description then it should return '#expectedEcho'"() {
		when: "#description  is passed to the service"
		def echo = service.generateEcho(arg)

		then: "the echo should be '#expectedEcho'"
		echo == expectedEcho
		
		where:
		description       | arg      || expectedEcho
		"LOUD"            | "LOUD"   || "LOUD... loud..."
		"Normal"          | "Normal" || "Normal... normal..."
		"soft"            | "soft"   || "soft..."
		"an empty String" | ""       || "..."		
	}
}
