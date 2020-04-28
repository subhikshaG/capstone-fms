package com.cts.events.service;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import com.cts.events.model.Dashboard;
import com.cts.events.repository.EventSummaryRepository;
import com.cts.events.repository.EventsRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class EventsService {

	@Autowired
	private EventsRepository eventRepository;

	@Autowired
	private EventSummaryRepository eventSummaryRepository;

	public Mono<String> getAuthorities() {
		return ReactiveSecurityContextHolder.getContext()
				.map(s -> s.getAuthentication().getAuthorities().toArray()[0].toString());

	}

	public Mono<String> getCurrentUser() {
		return ReactiveSecurityContextHolder.getContext()
				.switchIfEmpty(Mono.error(new IllegalStateException("ReactiveSecurityContext is empty")))
				.map(SecurityContext::getAuthentication).map(Authentication::getPrincipal).map(auth -> auth.toString());

	}

}
