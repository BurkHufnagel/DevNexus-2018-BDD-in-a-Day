package com.bddinaday.echo.service;

import org.springframework.stereotype.Service;


@Service
public class EchoService {

	public String buildEcho(String sound) {
		return sound;
	}
}
