package com.cts.fmsevent.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FeedbackDashboard
 */
@Validated
@Getter
@Setter
@NoArgsConstructor
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-04-06T11:49:37.085+05:30")

public class FeedbackDashboard {

	@JsonProperty("feedbackId")
	private Integer feedbackId = null;
	
	@JsonProperty("question")
	private String question = null;

	@JsonProperty("totalAnswer")
	private Long totalAnswer = null;

	@JsonProperty("feedbackType")
	private String feedbackType = null;

	public FeedbackDashboard question(String question) {
		this.question = question;
		return this;
	}
}

//  /**
//   * Get question
//   * @return question
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public String getQuestion() {
//    return question;
//  }
//
//  public void setQuestion(String question) {
//    this.question = question;
//  }
//
//  public FeedbackDashboard totalAnswer(Integer totalAnswer) {
//    this.totalAnswer = totalAnswer;
//    return this;
//  }
//
//  /**
//   * Get totalAnswer
//   * @return totalAnswer
//  **/
//  @ApiModelProperty(value = "")
//
//
//  public Integer getTotalAnswer() {
//    return totalAnswer;
//  }
//
//  public void setTotalAnswer(Integer totalAnswer) {
//    this.totalAnswer = totalAnswer;
//  }
//
//  public FeedbackDashboard feedbackType(String feedbackType) {
//    this.feedbackType = feedbackType;
//    return this;
//  }

/**
 * Get feedbackType
 * 
 * @return feedbackType
 **/
//  @ApiModelProperty(value = "")
//
//
//  public String getFeedbackType() {
//    return feedbackType;
//  }
//
//  public void setFeedbackType(String feedbackType) {
//    this.feedbackType = feedbackType;
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
//    FeedbackDashboard feedbackDashboard = (FeedbackDashboard) o;
//    return Objects.equals(this.question, feedbackDashboard.question) &&
//        Objects.equals(this.totalAnswer, feedbackDashboard.totalAnswer) &&
//        Objects.equals(this.feedbackType, feedbackDashboard.feedbackType);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(question, totalAnswer, feedbackType);
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("class FeedbackDashboard {\n");
//    
//    sb.append("    question: ").append(toIndentedString(question)).append("\n");
//    sb.append("    totalAnswer: ").append(toIndentedString(totalAnswer)).append("\n");
//    sb.append("    feedbackType: ").append(toIndentedString(feedbackType)).append("\n");
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
//}
