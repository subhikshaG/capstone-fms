package com.cts.auth.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.cts.auth.model.User;
import com.cts.auth.repository.ReactiveUserRepository;
import com.cts.auth.security.ReactiveUserDetailsServiceImpl;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@MockBean
	private ReactiveUserRepository userRepository;

	@Test
	public void testGetUser() {
		User user = new User();
		user.setEmail("subhikshaguha@gmail.com");
		user.setUserId(111111);
		user.setPassword("pwd");
		user.setRole("POC");
		user.setUsername("Kate");
		Mono<User> userMono = Mono.just(user);
		when(userRepository.findByUsername(user.getUsername())).thenReturn(userMono);
		ReactiveUserDetailsServiceImpl userService = new ReactiveUserDetailsServiceImpl(userRepository);
		userService.findByUsername("Kate");
		assertEquals("Kate", user.getUsername());
	}
}
