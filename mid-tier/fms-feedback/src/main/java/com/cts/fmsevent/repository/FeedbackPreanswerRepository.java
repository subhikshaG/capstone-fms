package com.cts.fmsevent.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.fmsevent.model.FeedbackPreanswer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface FeedbackPreanswerRepository extends ReactiveCrudRepository<FeedbackPreanswer, Integer>{

	@Query("select *from feedback_preanswer f where f.feedback_id = :feedbackId")
	Flux<FeedbackPreanswer> findByFeedbackId(Integer feedbackId);

	@Query("delete from feedback.feedback_preanswer where feedback_id = :feedbackId")
	Mono<Void> deleteByFeedbackId(Integer feedbackId);
	
	@Query("select count(*) from feedback.feedback_preanswer where feedback_id = :feedbackId")
	Mono<Long> countAnswer(Integer feedbackId);

}
