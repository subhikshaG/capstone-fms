package com.cts.events.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * EventSummary
 */
@Validated
@Data
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-11T13:54:25.092+05:30")
@Table("event_summary")
public class EventSummary {
	@JsonProperty("summaryId")
	@Id
	private Integer summaryId = null;

	@JsonProperty("totalVolunteer")
	private Integer totalVolunteer = null;

	@JsonProperty("noOfHrs")
	private Double noOfHrs = null;

	@JsonProperty("travelHrs")
	private Double travelHrs = null;

	@JsonProperty("livesImpact")
	private Integer livesImpact = null;

	@JsonProperty("avgVolunteer")
	private Double avgVolunteer = null;

	@JsonProperty("eventId")
	// @Column("event_summary_summary")
	private Integer eventId = null;

}
