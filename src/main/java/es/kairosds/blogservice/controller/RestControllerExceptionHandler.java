package es.kairosds.blogservice.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import es.kairosds.blogservice.exception.ComentarioOfensivoException;

@ControllerAdvice
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	protected ResponseEntity<Object> handleConflict(RuntimeException ex,
													WebRequest request){
		String bodyOfResponse = "Resource not found";
		return handleExceptionInternal(ex,
				bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(ComentarioOfensivoException.class)
	protected ResponseEntity<Object> handleComentarioOfensivo(RuntimeException ex,
																WebRequest request){
		String bodyOfResponse = "Resource not found";
		return handleExceptionInternal(ex,
				bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
		
	}
	
}
