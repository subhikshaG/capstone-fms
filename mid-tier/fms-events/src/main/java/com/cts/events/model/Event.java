package com.cts.events.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-11T13:54:25.092+05:30")
@Data
@Builder
public class Event {
	@JsonProperty("eventId")
	@Id
	private Integer eventId = null;

	@JsonProperty("eventNo")
	private String eventNo = null;

	@JsonProperty("month")
	private String month = null;

	@JsonProperty("location")
	private String location = null;

	@JsonProperty("beneficiaryName")
	private String beneficiaryName = null;

	@JsonProperty("address")
	private String address = null;

	@JsonProperty("councilName")
	private String councilName = null;

	@JsonProperty("project")
	private String project = null;

	@JsonProperty("category")
	private String category = null;

	@JsonProperty("eventName")
	private String eventName = null;

	@JsonProperty("eventDescription")
	private String eventDescription = null;

}
