package com.mybookmark.mybookmarkapi.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.web.error.exception.HttpBadConextPathException;


@RestController
@RequestMapping(value="/**")
public class GlobalPathController {
	
	@RequestMapping()
	public void throwHttpBadContextPathException() {
		throw new HttpBadConextPathException();
	}
}
