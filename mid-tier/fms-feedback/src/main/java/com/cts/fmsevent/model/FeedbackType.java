package com.cts.fmsevent.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * FeedbackType
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-18T16:20:05.203+05:30")
@Table("feedback_type")
public class FeedbackType {
	@Id
	@JsonProperty("feedbackTypeId")
	private Integer feedbackTypeId = null;

	@JsonProperty("feedbackName")
	private String feedbackName = null;

	public FeedbackType feedbackTypeId(Integer feedbackTypeId) {
		this.feedbackTypeId = feedbackTypeId;
		return this;
	}

	/**
	 * Get feedbackTypeId
	 * 
	 * @return feedbackTypeId
	 **/
	@ApiModelProperty(value = "")

	public Integer getFeedbackTypeId() {
		return feedbackTypeId;
	}

	public void setFeedbackTypeId(Integer feedbackTypeId) {
		this.feedbackTypeId = feedbackTypeId;
	}

	public FeedbackType feedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
		return this;
	}

	/**
	 * Get feedbackName
	 * 
	 * @return feedbackName
	 **/
	@ApiModelProperty(value = "")

	public String getFeedbackName() {
		return feedbackName;
	}

	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FeedbackType feedbackType = (FeedbackType) o;
		return Objects.equals(this.feedbackTypeId, feedbackType.feedbackTypeId)
				&& Objects.equals(this.feedbackName, feedbackType.feedbackName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(feedbackTypeId, feedbackName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class FeedbackType {\n");

		sb.append("    feedbackTypeId: ").append(toIndentedString(feedbackTypeId)).append("\n");
		sb.append("    feedbackName: ").append(toIndentedString(feedbackName)).append("\n");
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
