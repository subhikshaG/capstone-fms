package com.cts.upload.model;


import java.sql.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;
/**
 * Event
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-16T13:11:05.707+05:30")
@Builder
public class Event   {
	@Id
  @JsonProperty("eventId")
  private Integer eventId;

  @JsonProperty("eventNo")
  private String eventNo;

  @JsonProperty("month")
  private String month;

  @JsonProperty("location")
  private String location;

  @JsonProperty("beneficiaryName")
  private String beneficiaryName;

  @JsonProperty("address")
  private String address;

  @JsonProperty("councilName")
  private String councilName;

  @JsonProperty("project")
  private String project;

  @JsonProperty("category")
  private String category;

  @JsonProperty("eventName")
  private String eventName;

  @JsonProperty("eventDescription")
  private String eventDescription;


  public Event eventId(Integer eventId) {
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

  public Event eventNo(String eventNo) {
    this.eventNo = eventNo;
    return this;
  }

  /**
   * Get eventNo
   * @return eventNo
  **/
  @ApiModelProperty(value = "")


  public String getEventNo() {
    return eventNo;
  }

  public void setEventNo(String eventNo) {
    this.eventNo = eventNo;
  }

  public Event month(String month) {
    this.month = month;
    return this;
  }

  /**
   * Get month
   * @return month
  **/
  @ApiModelProperty(value = "")


  public String getMonth() {
    return month;
  }

  public void setMonth(String month) {
    this.month = month;
  }

  public Event location(String location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")


  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Event beneficiaryName(String beneficiaryName) {
    this.beneficiaryName = beneficiaryName;
    return this;
  }

  /**
   * Get beneficiaryName
   * @return beneficiaryName
  **/
  @ApiModelProperty(value = "")


  public String getBeneficiaryName() {
    return beneficiaryName;
  }

  public void setBeneficiaryName(String beneficiaryName) {
    this.beneficiaryName = beneficiaryName;
  }

  public Event address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  **/
  @ApiModelProperty(value = "")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Event councilName(String councilName) {
    this.councilName = councilName;
    return this;
  }

  /**
   * Get councilName
   * @return councilName
  **/
  @ApiModelProperty(value = "")


  public String getCouncilName() {
    return councilName;
  }

  public void setCouncilName(String councilName) {
    this.councilName = councilName;
  }

  public Event project(String project) {
    this.project = project;
    return this;
  }

  /**
   * Get project
   * @return project
  **/
  @ApiModelProperty(value = "")


  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public Event category(String category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Event eventName(String eventName) {
    this.eventName = eventName;
    return this;
  }

  /**
   * Get eventName
   * @return eventName
  **/
  @ApiModelProperty(value = "")


  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Event eventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
    return this;
  }

  /**
   * Get eventDescription
   * @return eventDescription
  **/
  @ApiModelProperty(value = "")


  public String getEventDescription() {
    return eventDescription;
  }

  public void setEventDescription(String eventDescription) {
    this.eventDescription = eventDescription;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Event event = (Event) o;
    return Objects.equals(this.eventId, event.eventId) &&
        Objects.equals(this.eventNo, event.eventNo) &&
        Objects.equals(this.month, event.month) &&
        Objects.equals(this.location, event.location) &&
        Objects.equals(this.beneficiaryName, event.beneficiaryName) &&
        Objects.equals(this.address, event.address) &&
        Objects.equals(this.councilName, event.councilName) &&
        Objects.equals(this.project, event.project) &&
        Objects.equals(this.category, event.category) &&
        Objects.equals(this.eventName, event.eventName) &&
        Objects.equals(this.eventDescription, event.eventDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(eventId, eventNo, month, location, beneficiaryName, address, councilName, project, category, eventName, eventDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event {\n");
    
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    eventNo: ").append(toIndentedString(eventNo)).append("\n");
    sb.append("    month: ").append(toIndentedString(month)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    beneficiaryName: ").append(toIndentedString(beneficiaryName)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    councilName: ").append(toIndentedString(councilName)).append("\n");
    sb.append("    project: ").append(toIndentedString(project)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    eventName: ").append(toIndentedString(eventName)).append("\n");
    sb.append("    eventDescription: ").append(toIndentedString(eventDescription)).append("\n");
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

