package com.cts.events.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-11T13:54:25.092+05:30")
@Table("user")
@Data
@Slf4j
public class User {

	@Id
	private int userId;

	@JsonProperty("userName")
	private String userName = null;

	@JsonProperty("password")
	private String password = null;

	@JsonProperty("email")
	private String email = null;

	@JsonProperty("contactNumber")
	private String contactNumber = null;

	@JsonProperty("role")
	private String role = null;

	@JsonProperty("businessUnit")
	private String businessUnit = null;

	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

		log.info("role is" + getRole());
		list.add(new SimpleGrantedAuthority(getRole()));

		return list;
	}

}
