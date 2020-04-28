package com.cts.events.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Dashboard {

	private Long totalEvents ;
	private Integer livesImpacted ;
	private Integer totalVolunteers;
	private Integer totalParticipants;
}
