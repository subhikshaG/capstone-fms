package com.cts.upload.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.upload.model.Event;


@Repository
public interface EventsRepository extends ReactiveCrudRepository<Event, Integer>{

}
