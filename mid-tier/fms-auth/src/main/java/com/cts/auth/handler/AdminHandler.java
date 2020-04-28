package com.cts.auth.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.common.response.BasicResponse;
import com.cts.auth.constant.ResponseStatus;
import com.cts.auth.model.Role;
import com.cts.auth.model.User;
import com.cts.auth.repository.ReactiveUserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class AdminHandler {
	@Autowired
	ReactiveUserRepository userRepository;

	public Mono<ServerResponse> hello(ServerRequest request) {
		log.info("role is" + Role.PMO.name());
		return ServerResponse.ok().body(fromObject(new BasicResponse(ResponseStatus.OK)));
	}

	
	public Mono<ServerResponse> configureRole(ServerRequest request) {
		return this.userRepository.findById(Integer.parseInt(request.pathVariable("id"))).flatMap(user -> {
			user.setRole(request.pathVariable("role"));
			log.info("user" + user);
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userRepository.save(user),
					User.class);
		}).switchIfEmpty(ServerResponse.notFound().build());
	}
}
