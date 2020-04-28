package com.cts.fmsevent.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.cts.fmsevent.model.FeedbackAnswer;
import com.cts.fmsevent.model.FeedbackDashboard;
import com.cts.fmsevent.model.FeedbackPreanswer;
import com.cts.fmsevent.model.FeedbackQuesAns;
import com.cts.fmsevent.repository.FeedbackPreanswerRepository;
import com.cts.fmsevent.repository.FeedbackRepository;
import com.cts.fmsevent.repository.FeedbackTypeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-06T11:49:37.085+05:30")

@Controller
@Slf4j
public class FeedbackDashboardApiController implements FeedbackDashboardApi {

	@Autowired
	private FeedbackRepository feedbackRepository;

	@Autowired
	private FeedbackTypeRepository feedbackTypeRepository;

	@Autowired
	private FeedbackPreanswerRepository feedbackPreanswerRepository;
	


	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public FeedbackDashboardApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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

	public Mono<ResponseEntity<FeedbackQuesAns>> feedbackDashboardFeedbackIdGet(Integer feedbackId) {
		log.info("feedback by id");
		FeedbackQuesAns feedbackQuesAns = new FeedbackQuesAns();
		List<FeedbackPreanswer> feedbackAns = new ArrayList();
		return this.feedbackRepository.findById(feedbackId).map(feedback -> {
			feedbackQuesAns.setFeedbackId(feedback.getFeedbackId());
			feedbackQuesAns.setFeedbackAnswerType(feedback.getFeedbackAnswerType());
			feedbackQuesAns.setFeedbackQuestion(feedback.getFeedbackQuestion());
			feedbackQuesAns.setFeedbackType(feedback.getFeedbackType());
			return feedback;
		}).and(feedbackPreanswerRepository.findByFeedbackId(feedbackId).map(answer -> {

			feedbackAns.add(answer);
			feedbackQuesAns.setFeedbackAns(feedbackAns);
			return answer;
		})).then(Mono.just(new ResponseEntity(HttpStatus.ACCEPTED).ok(feedbackQuesAns)));
		
	}
	
	

}
