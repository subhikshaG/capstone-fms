/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cts.upload.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.upload.model.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Mono;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-13T10:19:49.709+05:30")

@Api(value = "dir", description = "the dir API")
public interface DirApi {

	Logger log = LoggerFactory.getLogger(DirApi.class);

	default Optional<ObjectMapper> getObjectMapper() {
		return Optional.empty();
	}

	default Optional<HttpServletRequest> getRequest() {
		return Optional.empty();
	}

	default Optional<String> getAcceptHeader() {
		return getRequest().map(r -> r.getHeader("Accept"));
	}

	@ApiOperation(value = "", nickname = "dirGet", notes = "upload files", tags = { "Dashboard", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful"),
			@ApiResponse(code = 404, message = "failure") })
	@RequestMapping(value = "/dir/events", produces = { "application/json" }, method = RequestMethod.POST)
	default Mono<ResponseEntity<String>> dirGet() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default DirApi interface so no example is generated");
		}
		return Mono.just((new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED)));
	}

	@ApiOperation(value = "", nickname = "dirGet", notes = "upload files", tags = { "Dashboard", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful"),
			@ApiResponse(code = 404, message = "failure") })
	@RequestMapping(value = "/dir/summary", produces = { "application/json" }, method = RequestMethod.POST)
	default Mono<ResponseEntity<String>> dirPostSummary() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default DirApi interface so no example is generated");
		}
		return Mono.just((new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED)));
	}

	@ApiOperation(value = "", nickname = "dirGet", notes = "upload files", tags = { "Dashboard", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful"),
			@ApiResponse(code = 404, message = "failure") })
	@RequestMapping(value = "/dir/notattended", produces = { "application/json" }, method = RequestMethod.POST)
	default Mono<ResponseEntity<String>> dirPostParticipantNotAttended() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default DirApi interface so no example is generated");
		}
		return Mono.just((new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED)));
	}

	@ApiOperation(value = "", nickname = "dirGet", notes = "upload files", tags = { "Dashboard", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successful"),
			@ApiResponse(code = 404, message = "failure") })
	@RequestMapping(value = "/dir/unregister", produces = { "application/json" }, method = RequestMethod.POST)
	default Mono<ResponseEntity<String>> dirPostParticipantUnregister() {
		if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
		} else {
			log.warn(
					"ObjectMapper or HttpServletRequest not configured in default DirApi interface so no example is generated");
		}
		return Mono.just((new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED)));
	}
}
