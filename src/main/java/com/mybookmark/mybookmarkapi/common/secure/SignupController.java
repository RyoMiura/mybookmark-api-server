package com.mybookmark.mybookmarkapi.common.secure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybookmark.mybookmarkapi.common.dto.UserDto;
import com.mybookmark.mybookmarkapi.domain.user.UserService;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

@RestController
public class SignupController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	DtoFormMapper dtoFormMapper;
	
	@RequestMapping(value = SecurityProperty.SIGNUP_URL, method = RequestMethod.POST)
	public void createUser(@RequestBody SignupForm input) {
		UserDto dto = dtoFormMapper.fromFormToDto(input, UserDto.class);
		userService.createCommonUser(dto);
	}
}
