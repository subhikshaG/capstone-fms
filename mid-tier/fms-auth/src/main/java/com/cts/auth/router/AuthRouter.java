package com.cts.auth.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.handler.AuthHandler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class AuthRouter {
    @Bean
    public RouterFunction<ServerResponse> authV1Route(AuthHandler authHandler) {
    	log.info("router");
        return RouterFunctions
                .route(RequestPredicates
                        .POST("/auth/signin")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), authHandler::signIn)
                ;
    }
}
