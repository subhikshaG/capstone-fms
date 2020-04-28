package com.cts.auth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@EqualsAndHashCode(of = "id")
@Table("user")
public class User {
	@Id
	@Getter
	@Setter
	private Integer userId;

	@Getter
	@Setter
	@NotBlank
	@Column("user_name")
	private String username;

	@Getter
	@Setter
	@NotBlank
	@JsonIgnore
	private String password;

	@Getter
	@Setter
	private String role;

	@Getter
	@Setter
	private String email;


	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

		log.info("role is" + getRole());
		list.add(new SimpleGrantedAuthority(getRole()));

		return list;
	}

}
