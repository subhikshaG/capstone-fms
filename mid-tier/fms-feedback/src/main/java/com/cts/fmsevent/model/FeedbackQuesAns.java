package com.cts.fmsevent.model;

import java.util.Objects;
import com.cts.fmsevent.model.FeedbackAnswer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FeedbackQuesAns
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")
@Data

public class FeedbackQuesAns   {
  @JsonProperty("feedbackId")
  private Integer feedbackId = null;

  @JsonProperty("feedbackType")
  private Integer feedbackType = null;

  @JsonProperty("feedbackAnswerType")
  private String feedbackAnswerType = null;

  @JsonProperty("feedbackQuestion")
  private String feedbackQuestion = null;

  @JsonProperty("feedbackAns")
  
  private List<FeedbackPreanswer> feedbackAns = null;

//  public FeedbackQuesAns feedbackId(Integer feedbackId) {
//    this.feedbackId = feedbackId;
//    return this;
//  }
//
//  /**
//   * Get feedbackId
//   * @return feedbackId
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public Integer getFeedbackId() {
//    return feedbackId;
//  }
//
//  public void setFeedbackId(Integer feedbackId) {
//    this.feedbackId = feedbackId;
//  }
//
//  public FeedbackQuesAns feedbackType(Integer feedbackType) {
//    this.feedbackType = feedbackType;
//    return this;
//  }
//
//  /**
//   * Get feedbackType
//   * @return feedbackType
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public Integer getFeedbackType() {
//    return feedbackType;
//  }
//
//  public void setFeedbackType(Integer feedbackType) {
//    this.feedbackType = feedbackType;
//  }
//
//  public FeedbackQuesAns feedbackAnswerType(String feedbackAnswerType) {
//    this.feedbackAnswerType = feedbackAnswerType;
//    return this;
//  }
//
//  /**
//   * Get feedbackAnswerType
//   * @return feedbackAnswerType
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public String getFeedbackAnswerType() {
//    return feedbackAnswerType;
//  }
//
//  public void setFeedbackAnswerType(String feedbackAnswerType) {
//    this.feedbackAnswerType = feedbackAnswerType;
//  }
//
//  public FeedbackQuesAns feedbackQuestion(String feedbackQuestion) {
//    this.feedbackQuestion = feedbackQuestion;
//    return this;
//  }
//
//  /**
//   * Get feedbackQuestion
//   * @return feedbackQuestion
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public String getFeedbackQuestion() {
//    return feedbackQuestion;
//  }
//
//  public void setFeedbackQuestion(String feedbackQuestion) {
//    this.feedbackQuestion = feedbackQuestion;
//  }
//
//  public FeedbackQuesAns feedbackAns(List<String> feedbackAns) {
//    this.feedbackAns = feedbackAns;
//    return this;
//  }
//
//  public FeedbackQuesAns addFeedbackAnsItem(FeedbackAnswer feedbackAnsItem) {
//    if (this.feedbackAns == null) {
//      this.feedbackAns = new ArrayList<>();
//    }
//    this.feedbackAns.add(feedbackAnsItem);
//    return this;
//  }
//
//  /**
//   * Get feedbackAns
//   * @return feedbackAns
//  **/
//  @ApiModelProperty(value = "")
//
//  @Valid
//
//  public List<FeedbackAnswer> getFeedbackAns() {
//    return feedbackAns;
//  }
//
//  public void setFeedbackAns(List<FeedbackAnswer> feedbackAns) {
//    this.feedbackAns = feedbackAns;
//  }
//
//
//  @Override
//  public boolean equals(java.lang.Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    FeedbackQuesAns feedbackQuesAns = (FeedbackQuesAns) o;
//    return Objects.equals(this.feedbackId, feedbackQuesAns.feedbackId) &&
//        Objects.equals(this.feedbackType, feedbackQuesAns.feedbackType) &&
//        Objects.equals(this.feedbackAnswerType, feedbackQuesAns.feedbackAnswerType) &&
//        Objects.equals(this.feedbackQuestion, feedbackQuesAns.feedbackQuestion) &&
//        Objects.equals(this.feedbackAns, feedbackQuesAns.feedbackAns);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(feedbackId, feedbackType, feedbackAnswerType, feedbackQuestion, feedbackAns);
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("class FeedbackQuesAns {\n");
//    
//    sb.append("    feedbackId: ").append(toIndentedString(feedbackId)).append("\n");
//    sb.append("    feedbackType: ").append(toIndentedString(feedbackType)).append("\n");
//    sb.append("    feedbackAnswerType: ").append(toIndentedString(feedbackAnswerType)).append("\n");
//    sb.append("    feedbackQuestion: ").append(toIndentedString(feedbackQuestion)).append("\n");
//    sb.append("    feedbackAns: ").append(toIndentedString(feedbackAns)).append("\n");
//    sb.append("}");
//    return sb.toString();
//  }
//
//  /**
//   * Convert the given object to string with each line indented by 4 spaces
//   * (except the first line).
//   */
//  private String toIndentedString(java.lang.Object o) {
//    if (o == null) {
//      return "null";
//    }
//    return o.toString().replace("\n", "\n    ");
//  }
}

