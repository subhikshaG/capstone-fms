package com.cts.fmsemail.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.fmsemail.model.EventDetails;

import reactor.core.publisher.Flux;



public interface EventDetailsRepository extends ReactiveCrudRepository<EventDetails, Integer>{

	
	@Query("select *from user_event as ue where ue.event_id= :eventId ")
	Flux<EventDetails> getUsersByEventId(Integer eventId);
}
