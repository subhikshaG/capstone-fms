package com.cts.upload.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.upload.model.User;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer>{

}
