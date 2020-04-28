package com.cts.events.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

import com.cts.events.security.AuthenticationManager;
import com.cts.events.security.SecurityContextRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {
	private final AuthenticationManager authenticationManager;
	private final SecurityContextRepository securityContextRepository;

	@Autowired
	public SecurityConfig(AuthenticationManager authenticationManager,
			SecurityContextRepository securityContextRepository) {
		this.authenticationManager = authenticationManager;
		this.securityContextRepository = securityContextRepository;
	}

	@Bean
	public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
		return http.csrf().disable().formLogin().disable().httpBasic().disable()
				.authenticationManager(authenticationManager).securityContextRepository(securityContextRepository)
				.authorizeExchange().pathMatchers("/admin/**").hasAnyAuthority("ADMIN")				
				.pathMatchers("/user/**").permitAll().anyExchange().permitAll().and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
