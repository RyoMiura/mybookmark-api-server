package com.mybookmark.mybookmarkapi.common.error.handler;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 各コントローラにおけるバリデーションチェック時に発生する例外のハンドラ。
 */
@ControllerAdvice
public class ValidationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ MethodArgumentNotValidException.class, HttpMessageNotReadableException.class })
	@ResponseBody
	public ErrorResponse handleValidationError(Exception e, HttpServletRequest request) {
		System.out.println(e.getClass());
		return new ErrorResponse(HttpStatus.BAD_REQUEST, request);
	}

	
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler({ HttpRequestMethodNotSupportedException.class })
	@ResponseBody
	public ErrorResponse handleMethodNotSupportedError(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
		System.out.println(e.getClass());
		return new ErrorResponse(HttpStatus.METHOD_NOT_ALLOWED, request);
	}

}
