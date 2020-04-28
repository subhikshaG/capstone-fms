package com.cts.events.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.events.model.EventDetails;

public interface EventDetailsRepository extends ReactiveCrudRepository<EventDetails, Integer>{

}
