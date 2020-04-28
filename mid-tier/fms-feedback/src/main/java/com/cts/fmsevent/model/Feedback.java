package com.cts.fmsevent.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

/**
 * Feedback
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")
@Table("feedback")
@Builder
public class Feedback {
	@Id
	@JsonProperty("feedbackId")
	private Integer feedbackId;

	@JsonProperty("feedbackType")
	private Integer feedbackType;

	@JsonProperty("feedbackAnswerType")
	private String feedbackAnswerType;

	@JsonProperty("feedbackQuestion")
	private String feedbackQuestion;

	public Feedback feedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
		return this;
	}

	/**
	 * Get feedbackId
	 * 
	 * @return feedbackId
	 **/
	@ApiModelProperty(value = "")

	public Integer getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Integer feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Feedback feedbackType(Integer feedbackType) {
		this.feedbackType = feedbackType;
		return this;
	}

	/**
	 * Get feedbackType
	 * 
	 * @return feedbackType
	 **/
	@ApiModelProperty(value = "")

	public Integer getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(Integer feedbackType) {
		this.feedbackType = feedbackType;
	}

	public Feedback feedbackAnswerType(String feedbackAnswerType) {
		this.feedbackAnswerType = feedbackAnswerType;
		return this;
	}

	/**
	 * Get feedbackAnswerType
	 * 
	 * @return feedbackAnswerType
	 **/
	@ApiModelProperty(value = "")

	public String getFeedbackAnswerType() {
		return feedbackAnswerType;
	}

	public void setFeedbackAnswerType(String feedbackAnswerType) {
		this.feedbackAnswerType = feedbackAnswerType;
	}

	public Feedback feedbackQuestion(String feedbackQuestion) {
		this.feedbackQuestion = feedbackQuestion;
		return this;
	}

	/**
	 * Get feedbackQuestion
	 * 
	 * @return feedbackQuestion
	 **/
	@ApiModelProperty(value = "")

	public String getFeedbackQuestion() {
		return feedbackQuestion;
	}

	public void setFeedbackQuestion(String feedbackQuestion) {
		this.feedbackQuestion = feedbackQuestion;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Feedback feedback = (Feedback) o;
		return Objects.equals(this.feedbackId, feedback.feedbackId)
				&& Objects.equals(this.feedbackType, feedback.feedbackType)
				&& Objects.equals(this.feedbackAnswerType, feedback.feedbackAnswerType)
				&& Objects.equals(this.feedbackQuestion, feedback.feedbackQuestion);
	}

	@Override
	public int hashCode() {
		return Objects.hash(feedbackId, feedbackType, feedbackAnswerType, feedbackQuestion);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Feedback {\n");

		sb.append("    feedbackId: ").append(toIndentedString(feedbackId)).append("\n");
		sb.append("    feedbackType: ").append(toIndentedString(feedbackType)).append("\n");
		sb.append("    feedbackAnswerType: ").append(toIndentedString(feedbackAnswerType)).append("\n");
		sb.append("    feedbackQuestion: ").append(toIndentedString(feedbackQuestion)).append("\n");
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
