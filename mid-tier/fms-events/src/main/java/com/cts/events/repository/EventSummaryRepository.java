package com.cts.events.repository;

import org.springframework.data.r2dbc.repository.Query;
//import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.events.model.Dashboard;
import com.cts.events.model.EventSummary;

import reactor.core.publisher.Mono;

public interface EventSummaryRepository extends
		ReactiveCrudRepository<EventSummary, Integer> {

	@Query("select *from event_summary s inner join event e on s.event_id = e.event_id where e.event_no = :eventId")
	Mono<EventSummary> getSummaryByEventId(String eventId);

	@Query("select count(summary_id) as totalEvents,  sum(lives_impact) as livesImpacted, sum(total_volunteer) as totalVolunteers, sum(total_volunteer) as totalParticipants from feedback.event_summary")
	Mono<Dashboard> getDashboardDetails();


}
