package com.cts.fmsemail.api;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.fmsemail.service.MailService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-20T11:50:20.200+05:30")

@Slf4j
@RestController
public class MailTypeApiController implements MailTypeApi {

	@Autowired
	private MailService mailService;

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public MailTypeApiController(ObjectMapper objectMapper, HttpServletRequest request) {
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

	@PostMapping("/mail/{eventId}")
	public Flux<ResponseEntity<String>> mailTypePost1(@PathVariable Integer eventId) {
		return this.mailService.sendFeedbackEmail(eventId).map(mail -> ResponseEntity.ok(mail));
	}
	
	@PostMapping("/eventMail/{email}")
	public void sendEventsMail(@PathVariable String email) {
		this.mailService.sendReportMail(email);
	}


}
