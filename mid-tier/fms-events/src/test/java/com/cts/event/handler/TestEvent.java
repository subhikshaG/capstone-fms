package com.cts.event.handler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.cts.events.handler.EventsHandler;
import com.cts.events.model.Event;
import com.cts.events.repository.EventSummaryRepository;
import com.cts.events.repository.EventsRepository;
import com.cts.events.repository.UserRepository;
import com.cts.events.router.EventsRouter;
import com.cts.events.service.EventsService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
public class TestEvent {

	@MockBean
	private EventsRepository eventsRepository;

	@Test
	public void testGetEventsById() {
		Event event = Event.builder().eventId(1).eventNo("EVM123456").address("india").beneficiaryName("SMC")
				.eventName("raise fund").councilName("zone 2").build();
		Mono<Event> EventMono = Mono.just(event);
		when(eventsRepository.findById(1)).thenReturn(EventMono);
		assertEquals("india", event.getAddress());
	}

	@Test
	public void testGetEvents() {
		Flux<Event> event = Flux.fromIterable(Arrays.asList(Event.builder().eventId(1).eventNo("EVM123456").address("india").beneficiaryName("SMC")
				.eventName("raise fund").councilName("zone 2").build(),Event.builder().eventId(2).eventNo("EVM123456").address("india").beneficiaryName("SMC")
				.eventName("raise fund").councilName("zone 2").build()));
		when(eventsRepository.findAll()).thenReturn(event);
	}

}