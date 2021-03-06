/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cts.fmsevent.api;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.fmsevent.model.FeedbackDashboard;
import com.cts.fmsevent.model.FeedbackQuesAns;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-06T11:49:37.085+05:30")

@Api(value = "feedbackDashboard", description = "the feedbackDashboard API")
public interface FeedbackDashboardApi {

	Logger log = LoggerFactory.getLogger(FeedbackDashboardApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "", nickname = "feedbackDashboardFeedbackIdGet", notes = "get feedback id", response = FeedbackDashboard.class, tags = {
			"get feedback id", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "get feedback id", response = FeedbackDashboard.class),
			@ApiResponse(code = 404, message = "No DataFound") })
	@RequestMapping(value = "/feedbackDashboard/{feedbackId}", produces = {
			"application/json" }, method = RequestMethod.GET)
	default Mono<ResponseEntity<FeedbackQuesAns>> feedbackDashboardFeedbackIdGet(
			@ApiParam(value = "", required = true) @PathVariable("feedbackId") Integer feedbackId) {

		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

	@ApiOperation(value = "", nickname = "feedbackDashboardGet", notes = "feedback dashboard", response = FeedbackDashboard.class, tags = {
			"feedback dashboard", })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "all feedback in dashboard", response = FeedbackDashboard.class),
			@ApiResponse(code = 404, message = "No DataFound") })
	@RequestMapping(value = "/feedbackDashboard", produces = { "application/json" }, method = RequestMethod.GET)
	default Mono<ResponseEntity<FeedbackDashboard>> feedbackDashboardGet() {

		return Mono.just(new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED));
	}

}
