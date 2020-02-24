package com.soma.authentication.exception.errorhandler;

import java.util.Date;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.soma.authentication.exception.ExceptionResponse;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
@RestControllerAdvice
public class AuthenticationErrorHandler {
	@ExceptionHandler(AuthenticationException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ExceptionResponse handleCustomException(AuthenticationException e) {
		return new ExceptionResponse(e.getMessage(), new Date());
	}
}
