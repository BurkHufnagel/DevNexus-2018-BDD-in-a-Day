package com.bddinaday.echo.service;

import org.springframework.stereotype.Service;


@Service
public class EchoService {

	public String buildEcho(String sound) {
		String echo = generateEcho(sound);
		return echo;
	}

	private String generateEcho(String sound) {
		if( sound == sound.toLowerCase()) { // If no upper case letters then no echo
			sound = sound +  "...";
		} else {
			sound = sound + "... " + sound.toLowerCase() + "...";
		}
		
		return sound;
	}
}
