package com.cts.auth.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.common.response.BasicResponse;
import com.cts.auth.constant.ResponseStatus;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@Component
public class UserHandler {
    public Mono<ServerResponse> hello(ServerRequest request) {
    	log.info("caled her");
        return ServerResponse.ok().body(fromObject(new BasicResponse(ResponseStatus.OK)));
    }
}
