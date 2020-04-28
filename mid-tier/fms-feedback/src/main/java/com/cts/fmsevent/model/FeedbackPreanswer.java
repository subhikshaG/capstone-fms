package com.cts.fmsevent.model;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class FeedbackPreanswer {
	@Id
	@JsonProperty("answerId")
	private Integer answerId;

	@JsonProperty("feedbackId")
	private Integer feedbackId;


	@JsonProperty("feedbackAnswer")
	private String feedbackAnswer;

}
