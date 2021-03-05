package com.udemy.rest.ws.exception.handler;

public class UserServiceCustomException extends RuntimeException {
	private static final long serialVersionUID = 1348771109171435607L;
	public UserServiceCustomException(String message) {
		super(message);
	}
}
