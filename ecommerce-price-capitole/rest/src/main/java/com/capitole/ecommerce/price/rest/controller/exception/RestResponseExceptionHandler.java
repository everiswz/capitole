package com.capitole.ecommerce.price.rest.controller.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capitole.ecommerce.price.exception.ProductoNotFoundException;
import com.capitole.ecommerce.price.rest.controller.exception.model.RestError;

@ControllerAdvice(basePackages = "com.capitole.ecommerce.price.rest")
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String ERROR_INTERNO = "Error";

	@ExceptionHandler(value = { ProductoNotFoundException.class })
	protected ResponseEntity<Object> handleProductNotFound(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Product not found";
		return this.handleExceptionInternal(ex,
				new RestError(ERROR_INTERNO, HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), bodyOfResponse), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { NullPointerException.class })
	protected ResponseEntity<Object> handleParameterError(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = "Invalid parameter";
		return this.handleExceptionInternal(ex,
				new RestError(ERROR_INTERNO, HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), bodyOfResponse), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler(value = { Exception.class })
	protected ResponseEntity<Object> handleRuntimeError(RuntimeException ex, WebRequest request) {
		return this.handleExceptionInternal(ex,
				new RestError(ERROR_INTERNO, HttpStatus.BAD_REQUEST.name(), HttpStatus.BAD_REQUEST.value(), ex.getMessage()), new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}

}
