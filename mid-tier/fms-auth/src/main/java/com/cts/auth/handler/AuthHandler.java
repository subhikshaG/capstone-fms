package com.cts.auth.handler;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.auth.common.response.BasicResponse;
import com.cts.auth.constant.ResponseStatus;
import com.cts.auth.exception.FailureToIssueTokenException;
import com.cts.auth.exception.InvalidAuthRequestException;
import com.cts.auth.exception.UnauthorizedUserException;
import com.cts.auth.request.AuthRequest;
import com.cts.auth.response.AuthResponse;
import com.cts.auth.security.JWTUtil;
import com.cts.auth.security.ReactiveUserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


@Slf4j
@Component
public class AuthHandler {
    private final JWTUtil jwtUtil;

    private final PasswordEncoder passwordEncoder;

   private final ReactiveUserDetailsServiceImpl userDetailsService;

  
    @Autowired
    public AuthHandler(@NotNull JWTUtil jwtUtil,
                         @NotNull PasswordEncoder passwordEncoder,
                         ReactiveUserDetailsServiceImpl userDetailsService
                         ) {
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
    }
    

    public Mono<ServerResponse> signIn(ServerRequest request) {
    	log.info("you are called");
        return request.body(toMono(AuthRequest.class))
                .switchIfEmpty(Mono.error(new InvalidAuthRequestException()))
                .flatMap(authRequest -> userDetailsService.findByUsername(authRequest.getUsername())
                        .switchIfEmpty(Mono.error(new UnauthorizedUserException(authRequest.getUsername())))
                        .flatMap(userDetails -> {
                            if (!passwordEncoder.matches(authRequest.getPassword(), userDetails.getPassword()))
                                return ServerResponse.badRequest().body(fromObject(new BasicResponse(ResponseStatus.BAD_REQUEST_UNAUTHORIZED)));

                            return jwtUtil.generateToken(userDetails)
                                    .switchIfEmpty(Mono.error(new FailureToIssueTokenException()))
                                    .flatMap(token -> ServerResponse.ok().body(fromObject(new AuthResponse(ResponseStatus.OK_TOKEN_ISSUED, token))));
                        })
                );
    }

	
}
