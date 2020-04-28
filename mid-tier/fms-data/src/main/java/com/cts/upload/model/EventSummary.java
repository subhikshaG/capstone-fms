package com.cts.upload.model;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

/**
 * EventSummary
 */
@Validated
@Builder
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-13T10:19:49.709+05:30")
@Table("event_summary")
public class EventSummary {
	@Id
	@JsonProperty("summaryId")
	private Integer summaryId;

	@JsonProperty("totalVolunteer")
	private Integer totalVolunteer;

	@JsonProperty("noOfHrs")
	private Double noOfHrs;

	@JsonProperty("travelHrs")
	private Double travelHrs;

	@JsonProperty("livesImpact")
	private Double livesImpact;

	@JsonProperty("avgVolunteer")
	private Double avgVolunteer;

	@JsonProperty("eventId")
	private Integer eventId;

	public EventSummary summaryId(Integer summaryId) {
		this.summaryId = summaryId;
		return this;
	}

	/**
	 * Get summaryId
	 * 
	 * @return summaryId
	 **/
	@ApiModelProperty(value = "")

	public Integer getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(Integer summaryId) {
		this.summaryId = summaryId;
	}

	public EventSummary totalVolunteer(Integer totalVolunteer) {
		this.totalVolunteer = totalVolunteer;
		return this;
	}

	/**
	 * Get totalVolunteer
	 * 
	 * @return totalVolunteer
	 **/
	@ApiModelProperty(value = "")

	public Integer getTotalVolunteer() {
		return totalVolunteer;
	}

	public void setTotalVolunteer(Integer totalVolunteer) {
		this.totalVolunteer = totalVolunteer;
	}

	public EventSummary noOfHrs(Double noOfHrs) {
		this.noOfHrs = noOfHrs;
		return this;
	}

	/**
	 * Get noOfHrs
	 * 
	 * @return noOfHrs
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Double getNoOfHrs() {
		return noOfHrs;
	}

	public void setNoOfHrs(Double noOfHrs) {
		this.noOfHrs = noOfHrs;
	}

	public EventSummary travelHrs(Double travelHrs) {
		this.travelHrs = travelHrs;
		return this;
	}

	/**
	 * Get travelHrs
	 * 
	 * @return travelHrs
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Double getTravelHrs() {
		return travelHrs;
	}

	public void setTravelHrs(Double travelHrs) {
		this.travelHrs = travelHrs;
	}

	public EventSummary livesImpact(Double livesImpact) {
		this.livesImpact = livesImpact;
		return this;
	}

	/**
	 * Get livesImpact
	 * 
	 * @return livesImpact
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Double getLivesImpact() {
		return livesImpact;
	}

	public void setLivesImpact(Double livesImpact) {
		this.livesImpact = livesImpact;
	}

	public EventSummary avgVolunteer(Double avgVolunteer) {
		this.avgVolunteer = avgVolunteer;
		return this;
	}

	/**
	 * Get avgVolunteer
	 * 
	 * @return avgVolunteer
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public Double getAvgVolunteer() {
		return avgVolunteer;
	}

	public void setAvgVolunteer(Double avgVolunteer) {
		this.avgVolunteer = avgVolunteer;
	}

	public EventSummary eventId(Integer eventId) {
		this.eventId = eventId;
		return this;
	}

	/**
	 * Get eventId
	 * 
	 * @return eventId
	 **/
	@ApiModelProperty(value = "")

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		EventSummary eventSummary = (EventSummary) o;
		return Objects.equals(this.summaryId, eventSummary.summaryId)
				&& Objects.equals(this.totalVolunteer, eventSummary.totalVolunteer)
				&& Objects.equals(this.noOfHrs, eventSummary.noOfHrs)
				&& Objects.equals(this.travelHrs, eventSummary.travelHrs)
				&& Objects.equals(this.livesImpact, eventSummary.livesImpact)
				&& Objects.equals(this.avgVolunteer, eventSummary.avgVolunteer)
				&& Objects.equals(this.eventId, eventSummary.eventId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(summaryId, totalVolunteer, noOfHrs, travelHrs, livesImpact, avgVolunteer, eventId);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class EventSummary {\n");

		sb.append("    summaryId: ").append(toIndentedString(summaryId)).append("\n");
		sb.append("    totalVolunteer: ").append(toIndentedString(totalVolunteer)).append("\n");
		sb.append("    noOfHrs: ").append(toIndentedString(noOfHrs)).append("\n");
		sb.append("    travelHrs: ").append(toIndentedString(travelHrs)).append("\n");
		sb.append("    livesImpact: ").append(toIndentedString(livesImpact)).append("\n");
		sb.append("    avgVolunteer: ").append(toIndentedString(avgVolunteer)).append("\n");
		sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
