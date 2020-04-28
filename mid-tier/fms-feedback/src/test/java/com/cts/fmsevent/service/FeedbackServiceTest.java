package com.cts.fmsevent.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.cts.fmsevent.model.Feedback;
import com.cts.fmsevent.model.FeedbackPreanswer;
import com.cts.fmsevent.model.FeedbackQuesAns;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FeedbackServiceTest {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testShowFeedback() {
		webTestClient.get().uri("/event/feedback").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectBodyList(Feedback.class);
	}

	@Test
	public void testShowFeedbackById() {
		webTestClient.get().uri("/event/feedback/1").accept(MediaType.APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectBody(Feedback.class);
	}

	@Test
	public void testPostFeedback() {
		List<FeedbackPreanswer> preanswer = new ArrayList<FeedbackPreanswer>();

		preanswer.add(FeedbackPreanswer.builder().feedbackAnswer("easy").build());
		FeedbackQuesAns feedbackQuesAns = new FeedbackQuesAns();
		feedbackQuesAns.setFeedbackQuestion("was the location easy test");
		feedbackQuesAns.setFeedbackAns(preanswer);
		feedbackQuesAns.setFeedbackType(2);
		feedbackQuesAns.setFeedbackAnswerType("Custom Question");

		webTestClient.post().uri("/event/feedback").accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.body(Mono.just(feedbackQuesAns), FeedbackPreanswer.class).exchange().expectStatus().isAccepted();
	}

}
