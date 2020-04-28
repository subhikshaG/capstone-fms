package com.cts.fmsevent.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fmsevent.model.Feedback;
import com.cts.fmsevent.model.FeedbackPreanswer;
import com.cts.fmsevent.model.FeedbackQuesAns;
import com.cts.fmsevent.repository.FeedbackPreanswerRepository;
import com.cts.fmsevent.repository.FeedbackRepository;
import com.cts.fmsevent.service.FeedbackAnswerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")

@RestController
@Slf4j
public class FeedbackApiController implements FeedbackApi {

	@Autowired
	FeedbackRepository feedbackRepository;

	@Autowired
	FeedbackAnswerService feedbackAnswerService;

	@Autowired
	FeedbackPreanswerRepository feedbackPreAnswerRepository;
	int fbId;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public FeedbackApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public Optional<ObjectMapper> getObjectMapper() {
		return Optional.ofNullable(objectMapper);
	}

	@Override
	public Optional<HttpServletRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public Mono<ResponseEntity<Feedback>> feedbackFbIdGet(Integer fbId) {
		return this.feedbackRepository.findById(fbId).map(feedback -> ResponseEntity.ok(feedback))
				.defaultIfEmpty(ResponseEntity.noContent().build());

	}

	@Override
	public Flux<ResponseEntity<Feedback>> feedbackGet() {
		log.info("in get feedback");
		return this.feedbackRepository.findAll().map(feedback -> ResponseEntity.ok(feedback))
				.defaultIfEmpty(ResponseEntity.noContent().build());
	}


	@Override
	public Mono<ResponseEntity<Void>> feedbackPost(FeedbackQuesAns feedback) {
		log.info("feedback post");
		Feedback fb = Feedback.builder().feedbackQuestion(feedback.getFeedbackQuestion())
				.feedbackType(feedback.getFeedbackType()).feedbackAnswerType(feedback.getFeedbackAnswerType()).build();

		return this.feedbackRepository.save(fb)
				.map(fbs -> this.feedbackAnswerService.feed(feedback.getFeedbackAns(), fbs.getFeedbackId()).subscribe())
				.then(Mono.just(new ResponseEntity<Void>(HttpStatus.ACCEPTED)));

	}

	@Override
	public Mono<ResponseEntity<Void>> feedbackPut(FeedbackQuesAns feedback) {
		log.info("feedback"+feedback.toString());
		
		return feedbackRepository.findById(feedback.getFeedbackId()).flatMap(existingFeedback -> {
			existingFeedback.setFeedbackQuestion(feedback.getFeedbackQuestion());
			existingFeedback.setFeedbackAnswerType(feedback.getFeedbackAnswerType());
			existingFeedback.setFeedbackType(feedback.getFeedbackType());
			return feedbackRepository.save(existingFeedback);
		})
			.then(Mono.just(new ResponseEntity<>(HttpStatus.ACCEPTED))); 

	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/feedbackPreAnswer/{feedbackId}")
	public Mono<ResponseEntity<Void>> feedbackAnswerPutTry(@RequestBody List<FeedbackPreanswer> feedbackAnswer,@PathVariable int feedbackId) {
		return feedbackPreAnswerRepository.deleteByFeedbackId(feedbackId)
				.thenMany(feedbackPreAnswerRepository.saveAll(feedbackAnswer))
				.then(Mono.just(new ResponseEntity(HttpStatus.ACCEPTED)));		
		
	}
}
