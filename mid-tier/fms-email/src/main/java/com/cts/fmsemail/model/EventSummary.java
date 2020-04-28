package com.cts.fmsemail.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventSummary
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-20T11:50:20.200+05:30")

public class EventSummary   {
  @JsonProperty("eventUserId")
  private Integer eventUserId = null;

  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("eventId")
  private Integer eventId = null;

  @JsonProperty("participation")
  private String participation = null;

  @JsonProperty("volunteerHr")
  private Integer volunteerHr = null;

  @JsonProperty("travelHr")
  private Integer travelHr = null;

  public EventSummary eventUserId(Integer eventUserId) {
    this.eventUserId = eventUserId;
    return this;
  }

  /**
   * Get eventUserId
   * @return eventUserId
  **/
  @ApiModelProperty(value = "")


  public Integer getEventUserId() {
    return eventUserId;
  }

  public void setEventUserId(Integer eventUserId) {
    this.eventUserId = eventUserId;
  }

  public EventSummary userId(Integer userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public EventSummary eventId(Integer eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * Get eventId
   * @return eventId
  **/
  @ApiModelProperty(value = "")


  public Integer getEventId() {
    return eventId;
  }

  public void setEventId(Integer eventId) {
    this.eventId = eventId;
  }

  public EventSummary participation(String participation) {
    this.participation = participation;
    return this;
  }

  /**
   * Get participation
   * @return participation
  **/
  @ApiModelProperty(value = "")


  public String getParticipation() {
    return participation;
  }

  public void setParticipation(String participation) {
    this.participation = participation;
  }

  public EventSummary volunteerHr(Integer volunteerHr) {
    this.volunteerHr = volunteerHr;
    return this;
  }

  /**
   * Get volunteerHr
   * @return volunteerHr
  **/
  @ApiModelProperty(value = "")


  public Integer getVolunteerHr() {
    return volunteerHr;
  }

  public void setVolunteerHr(Integer volunteerHr) {
    this.volunteerHr = volunteerHr;
  }

  public EventSummary travelHr(Integer travelHr) {
    this.travelHr = travelHr;
    return this;
  }

  /**
   * Get travelHr
   * @return travelHr
  **/
  @ApiModelProperty(value = "")


  public Integer getTravelHr() {
    return travelHr;
  }

  public void setTravelHr(Integer travelHr) {
    this.travelHr = travelHr;
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
    return Objects.equals(this.eventUserId, eventSummary.eventUserId) &&
        Objects.equals(this.userId, eventSummary.userId) &&
        Objects.equals(this.eventId, eventSummary.eventId) &&
        Objects.equals(this.participation, eventSummary.participation) &&
        Objects.equals(this.volunteerHr, eventSummary.volunteerHr) &&
        Objects.equals(this.travelHr, eventSummary.travelHr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventUserId, userId, eventId, participation, volunteerHr, travelHr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventSummary {\n");
    
    sb.append("    eventUserId: ").append(toIndentedString(eventUserId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    participation: ").append(toIndentedString(participation)).append("\n");
    sb.append("    volunteerHr: ").append(toIndentedString(volunteerHr)).append("\n");
    sb.append("    travelHr: ").append(toIndentedString(travelHr)).append("\n");
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

