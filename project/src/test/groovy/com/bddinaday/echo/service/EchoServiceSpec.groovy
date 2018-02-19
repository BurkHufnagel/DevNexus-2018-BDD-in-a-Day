package com.bddinaday.echo.service

import spock.lang.PendingFeature
import spock.lang.Shared
import spock.lang.Specification


public class EchoServiceSpec extends Specification {
	@Shared
	def service = new EchoService()


	def "when called with 'Bob' as the sound it should return 'Bob'"() {
		given: "the supplied sound is 'Bob'"
			def originalSound = "Bob"

		when: "'Bob' is passed to buildEcho"
			def echo = service.buildEcho(originalSound)

		then: "the echo should be 'Bob'"
			echo == originalSound
	}


		@PendingFeature
	def "when called with and empty String as the sound it should return 'The sound of silence'"() {
		given: "the initial sound is an empty String"
			def intialSound = ""

		when: "an empty is passed to buildEcho"
			def echo = service.buildEcho(intialSound)

		then: "the welcome message should be 'The sound of silence'"
			echo == "The sound of silence"
	}
}
