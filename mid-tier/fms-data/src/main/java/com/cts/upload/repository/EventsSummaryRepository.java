package com.cts.upload.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.upload.model.EventSummary;

@Repository
public interface EventsSummaryRepository extends ReactiveCrudRepository<EventSummary, Integer>{

}
