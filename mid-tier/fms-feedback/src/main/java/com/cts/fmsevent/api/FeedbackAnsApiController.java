package com.cts.fmsevent.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.cts.fmsevent.model.FeedbackAnswer;
import com.cts.fmsevent.repository.FeedbackAnswerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")

@Controller
public class FeedbackAnsApiController implements FeedbackAnsApi {

	@Autowired
	FeedbackAnswerRepository feedbackAnswerRepository;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public FeedbackAnsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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

	public Mono<ResponseEntity<Void>> feedbackAnsPost(List<FeedbackAnswer> feedbackAnswer) {
		return this.feedbackAnswerRepository.saveAll(feedbackAnswer)
				.then(Mono.just(new ResponseEntity<>(HttpStatus.ACCEPTED)));

	}

}
