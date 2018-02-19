package com.bddinaday.echo.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*

import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc

import com.bddinaday.echo.controller.EchoController

import spock.lang.PendingFeature
import spock.lang.Specification


class EchoServiceIntegrationSpec extends Specification {
	private EchoController controller = new EchoController()
	private MockMvc mockMvc = standaloneSetup(controller).build()
	private EchoService echoService = Spy(EchoService, constructorArgs:[])


	def setup() {
		controller.echoService = echoService
	}


	def "it should return a 'Bob' when passed 'Bob'"() {
		given: "the sound 'Bob'"
		def initialSound = "Bob"

		when: "the echo service is called and the sound passed in is 'Bob'"
		def response = mockMvc.perform(get("/api/echo?sound=" + initialSound))
			.andReturn().getResponse()

		then: "the EchoService's buildEcho should have been called once"
		1 * echoService.buildEcho("Bob")

		and: "the HTTP response should indicate the call succeeded"
		response.getStatus() == HttpStatus.OK.value()

		and: "the original sound should have been returned"
		response.getContentAsString() == "Bob"
	}


	@PendingFeature
	def "it should return a 'The sound of silence' when passed an empty String"() {
		given: "the sound ''"
		def initialSound = ""

		when: "the echo service is called and the sound passed in is an empty String"
		def response = mockMvc.perform(get("/api/echo?sound=" + initialSound))
			.andReturn().getResponse()

		then: "the EchoService's buildEcho should have been called once"
		1 * echoService.buildEcho("")

		and: "the HTTP response should indicate the call succeeded"
		response.getStatus() == HttpStatus.OK.value()

		and: "the it should have returned 'The sound of silence'"
		response.getContentAsString() == "The sound of silence"
	}
}