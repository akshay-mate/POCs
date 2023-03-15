package com.jpa.test;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication

@EnableWebSecurity


public class BootjpaexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootjpaexampleApplication.class, args);
	}


	@Bean
	public OpenAPI openApiConfig() {
		return new OpenAPI().info(apiInfo());
	}

	public Info apiInfo() {
		Info info = new Info();
		info
				.title("JPA CRUD API")
				.description("JPA PROJECT REST API documents for RESTful web services")
				.version("v1.0.0");
		return info;
	}



}
