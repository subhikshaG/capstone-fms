package com.cts.fmsevent.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * FeedbackAnswer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T17:42:01.202+05:30")
@Table("feedback_answer")
@Builder
public class FeedbackAnswer {
	@Id
	@JsonProperty("feedbackAnswerId")
	private Integer feedbackAnswerId;

	@JsonProperty("feedbackId")
	private Integer feedbackId;

	@JsonProperty("userId")
	private Integer userId;

	@JsonProperty("feedbackAnswer")
	private String feedbackAnswer;

	public FeedbackAnswer feedbackAnswerId(Integer feedbackAnswerId) {
		this.feedbackAnswerId = feedbackAnswerId;
		return this;
	}

	/**
	 * Get feedbackAnswerId
	 * 
	 * @return feedbackAnswerId
	 **/
	@ApiModelProperty(value = "")

	public Integer getFeedbackAnswerId() {
		return feedbackAnswerId;
	}

	public void setFeedbackAnswerId(Integer feedbackAnswerId) {
		this.feedbackAnswerId = feedbackAnswerId;
	}

	public FeedbackAnswer feedbackId(Integer feedbackId) {
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

	public FeedbackAnswer userId(Integer userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * Get userId
	 * 
	 * @return userId
	 **/
	@ApiModelProperty(value = "")

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public FeedbackAnswer feedbackAnswer(String feedbackAnswer) {
		this.feedbackAnswer = feedbackAnswer;
		return this;
	}

	/**
	 * Get feedbackAnswer
	 * 
	 * @return feedbackAnswer
	 **/
	@ApiModelProperty(value = "")

	public String getFeedbackAnswer() {
		return feedbackAnswer;
	}

	public void setFeedbackAnswer(String feedbackAnswer) {
		this.feedbackAnswer = feedbackAnswer;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeedbackAnswer feedbackAnswer = (FeedbackAnswer) o;
		return Objects.equals(this.feedbackAnswerId, feedbackAnswer.feedbackAnswerId)
				&& Objects.equals(this.feedbackId, feedbackAnswer.feedbackId)
				&& Objects.equals(this.userId, feedbackAnswer.userId)
				&& Objects.equals(this.feedbackAnswer, feedbackAnswer.feedbackAnswer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(feedbackAnswerId, feedbackId, userId, feedbackAnswer);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FeedbackAnswer {\n");

		sb.append("    feedbackAnswerId: ").append(toIndentedString(feedbackAnswerId)).append("\n");
		sb.append("    feedbackId: ").append(toIndentedString(feedbackId)).append("\n");
		sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
		sb.append("    feedbackAnswer: ").append(toIndentedString(feedbackAnswer)).append("\n");
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
