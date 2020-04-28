package com.cts.events.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.cts.events.exception.JsonWebTokenNotFoundException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JWTUtil implements Serializable {

	private String secret = "mysecret";

	private long expirationTime = 3600000;

	@Getter
	@Setter
	private String token;

	public static final String CLAIM_KEY_AUTHORITIES = "userAuthorities";
	private static final String CLAIM_KEY_NON_EXPIRED = "isUserNonExpired";
	private static final String CLAIM_KEY_IS_ENABLED = "isUserEnabled";

	public Mono<String> generateToken(UserDetails user) {
		final Date tokenIssuedDate = new Date();
		final Date tokenExpirationDate = new Date(tokenIssuedDate.getTime() + expirationTime);

		final Map<String, Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_AUTHORITIES, user.getAuthorities());
		claims.put(CLAIM_KEY_NON_EXPIRED, user.isAccountNonExpired());
		claims.put(CLAIM_KEY_IS_ENABLED, user.isEnabled());

		return Mono.just(Jwts.builder().setClaims(claims).setSubject(user.getUsername()).setIssuedAt(tokenIssuedDate)
				.setExpiration(tokenExpirationDate).signWith(SignatureAlgorithm.HS512, secret).compact());
	}

	public Mono<Boolean> validateToken(String token) {
		this.token = token;
		return getClaimsFromToken(token).switchIfEmpty(Mono.error(new JsonWebTokenNotFoundException(token)))
				.flatMap(claims -> {
					final Date tokenExpirationDate = claims.getExpiration();
					log.info("role is");
					if (!tokenExpirationDate.after(new Date()))
						return Mono.just(Boolean.FALSE);

					final Boolean isUserNonExpired = claims.get(CLAIM_KEY_NON_EXPIRED, Boolean.class);
					final Boolean isUserEnabled = claims.get(CLAIM_KEY_IS_ENABLED, Boolean.class);

					if (!isUserEnabled || !isUserNonExpired)
						return Mono.just(Boolean.FALSE);

					return Mono.just(Boolean.TRUE);
				});
	}

	public Mono<String> getUsernameFromToken(String token) {
		return getClaimsFromToken(token).switchIfEmpty(Mono.error(new JsonWebTokenNotFoundException(token)))
				.flatMap(claims -> Mono.just(claims.getSubject()));
	}

	public Mono<Claims> getClaimsFromToken(String token) {
		log.info("my message" + Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
		return Mono.just(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
	}

	public String getAuthority() {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(this.token).getBody().getSubject();
	}

}