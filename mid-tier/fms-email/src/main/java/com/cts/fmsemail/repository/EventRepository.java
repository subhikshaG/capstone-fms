package com.cts.fmsemail.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.fmsemail.model.Event;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EventRepository extends ReactiveCrudRepository<Event, Integer> {

	@Query("select *from event e where e.event_no = :eventNo ")
	Mono<Event> getEventsByEventNo(String eventNo);

	@Query("select *from event as e inner join user_event as ue on ue.event_id = e.event_id inner join user as u on ue.user_id = u.user_id where u.user_name = :user")
	Flux<Event> getEventsByUser(String user);
}
