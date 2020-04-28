package com.cts.auth.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.handler.UserHandler;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Configuration
public class UserRouter {
    @Bean
    public RouterFunction<ServerResponse> userV1Route(UserHandler userHandler) {
        return RouterFunctions
                .route(RequestPredicates
                        .GET("/user/hello")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), userHandler::hello)
                ;
    }
}
