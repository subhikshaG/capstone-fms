package com.cts.fmsevent.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmsevent.model.Feedback;

@Repository
public interface FeedbackRepository extends ReactiveCrudRepository<Feedback, Integer> {

}
