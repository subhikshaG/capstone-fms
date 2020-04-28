package com.cts.fmsevent.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmsevent.model.FeedbackType;

@Repository
public interface FeedbackTypeRepository extends ReactiveCrudRepository<FeedbackType, Integer> {

}
