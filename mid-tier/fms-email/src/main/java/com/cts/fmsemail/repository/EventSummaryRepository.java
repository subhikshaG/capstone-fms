package com.cts.fmsemail.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.fmsemail.model.EventSummary;

import reactor.core.publisher.Mono;

public interface EventSummaryRepository extends
ReactiveCrudRepository<EventSummary, Integer> {

@Query("select *from event_summary s inner join event e on s.event_id = e.event_id where e.event_no = :eventId")
Mono<EventSummary> getSummaryByEventId(String eventId);


}
