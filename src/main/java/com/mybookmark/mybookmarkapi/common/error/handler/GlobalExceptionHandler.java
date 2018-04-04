package com.mybookmark.mybookmarkapi.common.error.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(Exception.class)
//	@ResponseBody
//	public Map<String, String> handleInternalServerError() {
//		Map<String, String> errorMap = new HashMap<>();
//		errorMap.put("Status", HttpStatus.INTERNAL_SERVER_ERROR.toString());
//		errorMap.put("message", "internal server error");
//		return errorMap;
//	}
}
