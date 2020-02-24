package com.soma.authentication.exception;

import java.util.Date;

/**
 * @author <a href="mailto:gyore.soma@gmail.com">Soma Györe</a>
 */
public class ExceptionResponse {
	private String message;
	private Date timeStamp;

	public ExceptionResponse(String message, Date timeStamp) {
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
}
