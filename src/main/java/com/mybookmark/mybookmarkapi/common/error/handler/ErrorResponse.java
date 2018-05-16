package com.mybookmark.mybookmarkapi.common.error.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private Date timestamp;
	
	private String status;
	
	private String error;
	
	private String path;
	
	
	public ErrorResponse(HttpStatus status, HttpServletRequest request) {
		this.timestamp = new Date();
		this.status = status.toString();
		this.error = status.getReasonPhrase();
		this.path = request.getRequestURI();
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getPath() {
		return path;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
