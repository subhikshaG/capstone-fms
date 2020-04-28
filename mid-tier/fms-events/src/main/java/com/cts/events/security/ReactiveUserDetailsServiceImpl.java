package com.cts.events.security;

import java.util.Objects;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cts.events.model.User;
import com.cts.events.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {

	private final UserRepository userRepository;

	public ReactiveUserDetailsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Mono<UserDetails> findByUsername(String login) {
		return userRepository.findByUsername(login).filter(Objects::nonNull)
				.switchIfEmpty(
						Mono.error(new BadCredentialsException(String.format("User %s not found in database", login))))
				.map(this::createSpringSecurityUser);
	}

	private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				user.getAuthorities());
	}
}
