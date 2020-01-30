package com.test.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Manas Mohanty
 * 
 * The Class BadRequestException.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new bad request exception.
	 */
	public BadRequestException() {
		super();
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param cause the cause
	 */
	public BadRequestException(Throwable cause) {
		super(cause);
	}

}