package com.mybookmark.mybookmarkapi.web.error.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.mybookmark.mybookmarkapi.web.error.exception.HttpBadConextPathException;


@ControllerAdvice
public class RequestExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
	@ResponseBody
	public Map<String, Object> handleValidationError() {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "invalid json value");
		return errorMap;
	}

	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class, HttpBadConextPathException.class })
	@ResponseBody
	public Map<String, Object> handleContextPathError() {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "not useable resource path");
		return errorMap;
	}

	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	@ResponseBody
	public Map<String, Object> handleMethodNotSupportedError() {
		Map<String, Object> errorMap = new HashMap<String, Object>();
		errorMap.put("message", "method not allowed");
		return errorMap;
	}

}
