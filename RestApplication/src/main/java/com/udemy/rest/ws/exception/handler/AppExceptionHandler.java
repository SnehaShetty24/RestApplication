package com.udemy.rest.ws.exception.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.udemy.rest.ws.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		String errorMsgDesc = ex.getLocalizedMessage();
		if (errorMsgDesc == null) {
			errorMsgDesc = ex.toString();
		}

		ErrorMessage msg = new ErrorMessage(new Date(), errorMsgDesc);
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(value = { NullPointerException.class, UserServiceCustomException.class })
	public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request) {
		String errorMsgDesc = ex.getLocalizedMessage();
		if (errorMsgDesc == null) {
			errorMsgDesc = ex.toString();
		}

		ErrorMessage msg = new ErrorMessage(new Date(), errorMsgDesc);
		return new ResponseEntity<>(msg, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);

	}
}
