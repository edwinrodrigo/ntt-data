package com.manager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomErrorResponse.class)
	public final ResponseEntity<MessageException> handleGeneralExceptions(Exception ex) {
		MessageException me = new MessageException(ex.getMessage());
	    return new ResponseEntity<>(me, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	@ExceptionHandler(NotFoundException.class)
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatusCode status, WebRequest request) {
		MessageException me = new MessageException(ex.getMessage());
	    return new ResponseEntity<>(me, new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		Map<String, Object> errors= new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			errors.put(error.getField(), error.getDefaultMessage());
		});
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
	
	
}
