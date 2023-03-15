package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootjpaexampleApplication.class, args);
	}

}
