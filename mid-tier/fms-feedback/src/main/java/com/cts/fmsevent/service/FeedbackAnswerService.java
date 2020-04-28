package com.cts.fmsevent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fmsevent.model.FeedbackAnswer;
import com.cts.fmsevent.model.FeedbackPreanswer;
import com.cts.fmsevent.repository.FeedbackPreanswerRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class FeedbackAnswerService {
	@Autowired
	FeedbackPreanswerRepository feedbackPreanswerRepository;

	
	public Mono<Void> feed(List<FeedbackPreanswer> answers, int fb1) {

		log.info("fb1 is  ------ "+fb1);
		
		return Flux.fromIterable(answers).map(answer -> {
			FeedbackPreanswer fbans = FeedbackPreanswer.builder().feedbackAnswer(answer.getFeedbackAnswer()).feedbackId(fb1).build();
			System.out.println("is it even heree?");
			return this.feedbackPreanswerRepository.save(fbans).subscribe();

		}).then();
	}
}
