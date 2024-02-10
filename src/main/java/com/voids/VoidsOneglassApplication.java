package com.voids;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VoidsOneglassApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoidsOneglassApplication.class, args);
	}

}
