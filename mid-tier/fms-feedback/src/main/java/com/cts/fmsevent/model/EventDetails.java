package com.cts.fmsevent.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * EventDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")

public class EventDetails   {
  @JsonProperty("eventUserId")
  private Integer eventUserId = null;

  @JsonProperty("userId")
  private Integer userId = null;

  @JsonProperty("eventId")
  private Integer eventId = null;

  @JsonProperty("participation")
  private String participation = null;

  @JsonProperty("volunteerHr")
  private BigDecimal volunteerHr = null;

  @JsonProperty("travelHr")
  private BigDecimal travelHr = null;

  public EventDetails eventUserId(Integer eventUserId) {
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

  public EventDetails userId(Integer userId) {
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

  public EventDetails eventId(Integer eventId) {
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

  public EventDetails participation(String participation) {
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

  public EventDetails volunteerHr(BigDecimal volunteerHr) {
    this.volunteerHr = volunteerHr;
    return this;
  }

  /**
   * Get volunteerHr
   * @return volunteerHr
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getVolunteerHr() {
    return volunteerHr;
  }

  public void setVolunteerHr(BigDecimal volunteerHr) {
    this.volunteerHr = volunteerHr;
  }

  public EventDetails travelHr(BigDecimal travelHr) {
    this.travelHr = travelHr;
    return this;
  }

  /**
   * Get travelHr
   * @return travelHr
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getTravelHr() {
    return travelHr;
  }

  public void setTravelHr(BigDecimal travelHr) {
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
    EventDetails eventDetails = (EventDetails) o;
    return Objects.equals(this.eventUserId, eventDetails.eventUserId) &&
        Objects.equals(this.userId, eventDetails.userId) &&
        Objects.equals(this.eventId, eventDetails.eventId) &&
        Objects.equals(this.participation, eventDetails.participation) &&
        Objects.equals(this.volunteerHr, eventDetails.volunteerHr) &&
        Objects.equals(this.travelHr, eventDetails.travelHr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventUserId, userId, eventId, participation, volunteerHr, travelHr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDetails {\n");
    
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

