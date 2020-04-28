package com.cts.upload.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.upload.model.EventDetails;

@Repository
public interface EventsDetailsRepository extends ReactiveCrudRepository<EventDetails, Integer>{

}
