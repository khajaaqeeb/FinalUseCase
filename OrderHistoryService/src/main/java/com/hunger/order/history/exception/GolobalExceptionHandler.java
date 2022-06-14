package com.hunger.order.history.exception;



import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GolobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError object : ex.getBindingResult().getAllErrors()) {
			details.add(object.getDefaultMessage());
		}
		ErrorDetails errorDetails = new ErrorDetails(400L, details);
		// TODO Auto-generated method stub
		return new ResponseEntity<Object>(errorDetails,HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OrderHistoryNotFoundException.class)
	public ResponseEntity<Object> handleOrderHistoryNotFoundException(OrderHistoryNotFoundException ex,WebRequest request)
	{
		List<String> details = new ArrayList<>();

		details.add(ex.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(400L, details);

		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex,WebRequest request)
	{
		List<String> details = new ArrayList<>();

		details.add(ex.getMessage());
		ErrorDetails errorDetails = new ErrorDetails(500L, details);
		
		return new ResponseEntity<Object>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
