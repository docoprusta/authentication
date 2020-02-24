package com.soma.authentication.service;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soma.authentication.authentication.JwtGenerator;
import com.soma.authentication.model.User;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
@Service
public class AuthenticationService {
	// TODO get user from db, pw hash, etc.
	private final String USERNAME = "user";
	private final String PASSWORD = "pass";

	private JwtGenerator jwtGenerator;

	@Autowired
	public AuthenticationService(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}

	public String authenticate(User user) throws AuthenticationException {
		if (USERNAME.equals(user.getUsername()) && PASSWORD.equals(user.getPassword())) {
			return jwtGenerator.generate();
		}
		throw new AuthenticationException("Invalid credentials");
	}
}
