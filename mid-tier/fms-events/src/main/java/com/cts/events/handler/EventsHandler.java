package com.cts.events.handler;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.cts.events.model.Dashboard;
import com.cts.events.model.Event;
import com.cts.events.model.EventSummary;
import com.cts.events.model.User;
import com.cts.events.repository.EventSummaryRepository;
import com.cts.events.repository.EventsRepository;
import com.cts.events.repository.UserRepository;
import com.cts.events.service.EventsService;

@Slf4j
@Component
public class EventsHandler {
	@Autowired
	EventsRepository events;

	@Autowired
	EventSummaryRepository summary;

	@Autowired
	UserRepository userRepository;

	private final Mono<SecurityContext> context = ReactiveSecurityContextHolder.getContext();

	@Autowired
	EventsService eventsService;


	public Mono<ServerResponse> getEvent(ServerRequest request) {
		return this.events.findById(Integer.parseInt(request.pathVariable("id")))
				.flatMap(event -> ServerResponse.ok().body(Mono.just(event), Event.class))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getEventById(ServerRequest request) {
		return this.events.getEventsByEventNo(request.pathVariable("id"))
				.flatMap(event -> ServerResponse.ok().body(Mono.just(event), Event.class))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getAllEvent(ServerRequest request) {

		return this.eventsService.getAuthorities().flatMap(role -> {
			if (role.equals("ADMIN")) {
				return ok().contentType(MediaType.APPLICATION_JSON).body(events.findAll(), Event.class);
			} else {
				return this.eventsService.getCurrentUser().flatMap(user -> ok().contentType(MediaType.APPLICATION_JSON)
						.body(this.events.getEventsByUser(user), Event.class));
			}
		});
	}

	public Mono<ServerResponse> getAllEvents(ServerRequest request) {
		return ok().contentType(MediaType.APPLICATION_JSON).body(events.findAll(), Event.class);
	}

	public Mono<ServerResponse> createEvent(ServerRequest serverRequest) {
		return serverRequest.body(toMono(Event.class))
				.flatMap(req -> {
					log.info("event is" + req.getEventName());
					return ServerResponse.ok().body(events.save(req), Event.class);
				});
	}

	public Mono<ServerResponse> createEventList(ServerRequest serverRequest) {
		Flux<Event> event = serverRequest.bodyToFlux(Event.class);
		return ok().contentType(MediaType.APPLICATION_JSON).body(events.saveAll(event), Event.class);
	}

	public Mono<ServerResponse> getSummary(ServerRequest request) {
		int id = Integer.parseInt(request.pathVariable("id"));
		return ok().contentType(MediaType.APPLICATION_JSON).body(summary.findById(id), EventSummary.class);
	}

	public Mono<ServerResponse> getSummaryById(ServerRequest request) {
		return ok().contentType(MediaType.APPLICATION_JSON)
				.body(summary.getSummaryByEventId(request.pathVariable("id")), EventSummary.class);
	}

	public Mono<ServerResponse> configureRole(ServerRequest request) {
		return this.userRepository.findById(Integer.parseInt(request.pathVariable("id"))).flatMap(user -> {
			user.setRole(request.pathVariable("role"));
			log.info("user" + user);
			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userRepository.save(user),
					User.class);
		}).switchIfEmpty(ServerResponse.notFound().build());
	}

	public Mono<ServerResponse> getDashboardDetails(ServerRequest request) {
		Dashboard dashboard = new Dashboard();
		log.info("you are called");

		return this.summary.findAll().count().map(event -> {
			dashboard.setTotalEvents(event);
			return event;
		}).and(this.summary.findAll().map(lives -> lives.getLivesImpact()).reduce(0, (c, e) -> c + e).map(impact -> {
			dashboard.setLivesImpacted(impact);
			return impact;
		})).and(this.summary.findAll().map(volunteer -> volunteer.getTotalVolunteer()).reduce(0, (c, e) -> c + e)
				.map(volunteers -> {
					dashboard.setTotalVolunteers(volunteers);
					dashboard.setTotalParticipants(volunteers);
					return volunteers;
				})).then(ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(dashboard),
						Dashboard.class));

	}

	public Mono<ServerResponse> getEventByUser(ServerRequest request) {

		String role = request.pathVariable("user");

		if (role.equals("admin")) {
			return ok().contentType(MediaType.APPLICATION_JSON).body(events.findAll(), Event.class);
		} else {
			return ok().contentType(MediaType.APPLICATION_JSON).body(this.events.getEventsByUser(role), Event.class);

		}

	}
}
