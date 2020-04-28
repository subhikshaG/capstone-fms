package com.cts.fmsemail.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.cts.fmsemail.model.User;

import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
	@Query("select *from user where user_name=:username")
	Mono<User> findByUsername(String username);
	
}