package com.soma.authentication.controller;

import java.util.Map;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableMap;
import com.soma.authentication.model.User;
import com.soma.authentication.service.AuthenticationService;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
@RestController
public class LoginController {
	private AuthenticationService authenticationService;

	@Autowired
	public LoginController(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public Map<String, String> login(@RequestBody User user) throws AuthenticationException {
		String jwtToken = authenticationService.authenticate(user);
		return ImmutableMap.of("token", jwtToken);
	}
}
