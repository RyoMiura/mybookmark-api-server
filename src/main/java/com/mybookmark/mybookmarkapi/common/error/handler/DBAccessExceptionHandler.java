package com.mybookmark.mybookmarkapi.common.error.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mybookmark.mybookmarkapi.common.error.exception.NotFoundDBResourceException;

@ControllerAdvice
public class DBAccessExceptionHandler {

	@ResponseStatus(HttpStatus.CONFLICT)
	@ExceptionHandler({ DataIntegrityViolationException.class })
	@ResponseBody
	public Map<String, String> handleDuplicateDBValueError(Exception e) {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("Status", HttpStatus.CONFLICT.toString());
		errorMap.put("message", "can not add duplicate value");
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({ NotFoundDBResourceException.class, EmptyResultDataAccessException.class })
	@ResponseBody
	public Map<String, String> handleNotFoundDBResourceError() {
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("Status", HttpStatus.NOT_FOUND.toString());
		errorMap.put("message", "not found resource");
		return errorMap;
	}
}
