package com.mybookmark.mybookmarkapi.common.secure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;


/**
 * ユーザ認証フィルタ
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			LoginForm form = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);

			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(form.getLoginId(), form.getPassword(), new ArrayList<>()));

		} catch (IOException | SignatureException e) {
			throw new BadCredentialsException("bad request", e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String token = Jwts.builder()
				.setSubject(((UserDetails) authResult.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + SecurityProperty.TOKEN_PERIOD))
				.signWith(SecurityProperty.SECURITY_ALGORITHM, SecurityProperty.SECRET_KEY.getBytes())
				.compact();
		response.addHeader("Authorization", SecurityProperty.TOKEN_PREFIX + token);
	}

}
