package com.cts.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableR2dbcRepositories
@EnableWebFlux
public class FeedbackAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedbackAuthApplication.class, args);		
	}

}
