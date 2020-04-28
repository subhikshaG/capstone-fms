package com.cts.auth.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.handler.AdminHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AdminRouter {
	@Bean
	public RouterFunction<ServerResponse> adminV1Route(AdminHandler adminHandler) {
		return RouterFunctions
				.route(RequestPredicates.GET("/admin/hello")
						.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), adminHandler::hello)
				.andRoute(PUT("/configure/{id}/{role}").and(accept(MediaType.APPLICATION_JSON)),
						adminHandler::configureRole);
	}
}
