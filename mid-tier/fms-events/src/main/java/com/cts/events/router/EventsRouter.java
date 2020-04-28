package com.cts.events.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.cts.events.handler.EventsHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class EventsRouter {

	@Bean
	public RouterFunction<ServerResponse> routes(EventsHandler eventsHandler) {
		log.info("called");
		return RouterFunctions
				.route(GET("/events").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getAllEvent)
				
				.andRoute(GET("/events/{id}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getEventById)
				.andRoute(GET("/event/{id}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getEvent)
				.andRoute(POST("/eventlist").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::createEventList)
				.andRoute(GET("/summary/{id}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getSummary)
				.andRoute(GET("/summaryEve/{id}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getSummaryById)
				.andRoute(GET("/eventRole/{user}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getEventByUser)
				.andRoute(POST("/createEvent")
						.and(accept(MediaType.APPLICATION_JSON)/* .and(contentType(MediaType.APPLICATION_JSON)) */), eventsHandler::createEvent)
				.andRoute(GET("/dashboard").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getDashboardDetails)
				.andRoute(PUT("/configure/{id}/{role}").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::configureRole)
				.andRoute(GET("/allEvents").and(accept(MediaType.APPLICATION_JSON)), eventsHandler::getAllEvents);
	}

}
