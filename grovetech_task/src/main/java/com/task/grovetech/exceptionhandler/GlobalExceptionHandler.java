package com.task.grovetech.exceptionhandler;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler 
{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, Object> methodArgumentNotValidException(MethodArgumentNotValidException exception)
	{
		Map<String, Object> handleException = new LinkedHashMap<>();
		handleException.put("TimeStamp", System.currentTimeMillis());
		exception.getBindingResult().getFieldErrors().forEach((errors)->{
			handleException.put(errors.getField(),errors.getDefaultMessage());
		});
		return handleException;
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Object> dataNotFoundException(DataNotFoundException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourseAlreadyExistsException.class)
	public ResponseEntity<Object> resourseAlreadyExistsException(ResourseAlreadyExistsException exception)
	{
		ErrorResponse errorResponse = new ErrorResponse(exception.getMessage(), new Date());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
}
