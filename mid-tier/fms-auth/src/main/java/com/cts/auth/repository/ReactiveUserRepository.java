package com.cts.auth.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.auth.model.User;

import reactor.core.publisher.Mono;


@Repository
public interface ReactiveUserRepository extends ReactiveCrudRepository<User, Integer> {
    @Query("select *from user where user_name=:username")
	Mono<User> findByUsername(String username);
}
