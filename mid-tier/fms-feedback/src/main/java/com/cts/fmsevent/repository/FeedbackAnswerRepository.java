package com.cts.fmsevent.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmsevent.model.FeedbackAnswer;

@Repository
public interface FeedbackAnswerRepository extends ReactiveCrudRepository<FeedbackAnswer, Integer>{


}
