package com.mybookmark.mybookmarkapi.common.secure;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.common.error.handler.ErrorResponse;
import com.mybookmark.mybookmarkapi.domain.user.UserDto;
import com.mybookmark.mybookmarkapi.domain.user.UserService;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

@RestController
public class SignupController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DtoFormMapper dtoFormMapper;
	
	@RequestMapping(value = SecurityProperty.SIGNUP_URL, method = RequestMethod.POST)
	public void createUser(@RequestBody @Valid SignupForm input) {
		UserDto dto = dtoFormMapper.fromFormToDto(input, UserDto.class);
		userService.createCommonUser(dto);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	@ResponseBody
	public ErrorResponse conflictUsernameHandler(DataIntegrityViolationException e, HttpServletRequest request) {
		ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT, request);
		return error;
	}
	
}
