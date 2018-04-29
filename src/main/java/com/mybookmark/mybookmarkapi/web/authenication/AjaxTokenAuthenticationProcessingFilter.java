package com.mybookmark.mybookmarkapi.web.authenication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.util.WebUtils;

import com.mybookmark.mybookmarkapi.common.dto.LoginDto;
import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

public class AjaxTokenAuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {
	
	@Autowired
	private DtoFormMapper dtoFormMapper;
	
	protected AjaxTokenAuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		
//		LoginDto loginDto = dtoFormMapper.(request.getReader(), LoginDto.class);
		
		return null;
	}

}
