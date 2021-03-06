package com.mybookmark.mybookmarkapi.common.secure;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
 * ユーザ認可フィルタ。
 * BasicAuthenticationFilterを継承して実装する。
 * AuthorizationヘッダにつけられたJWTトークンから、ユーザの認可を行う。
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");

		if (header == null || !header.startsWith(SecurityProperty.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}

		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);

	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			try {
				String user = Jwts.parser()
						.setSigningKey(SecurityProperty.SECRET_KEY.getBytes())
						.parseClaimsJws(token.replaceAll(SecurityProperty.TOKEN_PREFIX, ""))
						.getBody()
						.getSubject();
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
				}
			} catch (ExpiredJwtException e) {
				// TODO: ここにログを残す
				// トークンの期限切れの場合は、ここでnullを返す。
				return null;
			}
		}
		return null;
	}

}
