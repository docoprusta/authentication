package com.soma.authentication.exception.errorhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.soma.authentication.exception.ExceptionResponse;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
@RestControllerAdvice
public class IllegalStateErrorHandler {
	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ExceptionResponse handleCustomException(IllegalStateException e) {
		return new ExceptionResponse(e.getMessage(), new Date());
	}
}
