package com.soma.authentication.authentication;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.soma.authentication.configuration.JwtConfiguration;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
@Component
public class JwtGenerator {
	public String generate() {
		try {
			Algorithm algorithm = Algorithm.HMAC256(JwtConfiguration.SECRET);
			return JWT.create()
					.withIssuer("auth0")
					.sign(algorithm);
		} catch (JWTCreationException | IllegalArgumentException e) {
			throw new IllegalStateException("Invalid Signing configuration / Couldn't convert Claims");
		}
	}
}
