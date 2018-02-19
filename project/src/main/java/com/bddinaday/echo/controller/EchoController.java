package com.bddinaday.echo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bddinaday.echo.service.EchoService;


@RestController
@RequestMapping(path="/api")
public class EchoController {
	@Autowired
	EchoService echoService;

	@GetMapping(path = "/echo")
	public String echo(String sound) {
		String echo = echoService.buildEcho(sound);

		return echo;
	}
}
