package com.mybookmark.mybookmarkapi.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import com.mybookmark.mybookmarkapi.common.dto.UserDto;
import com.mybookmark.mybookmarkapi.domain.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Bean
	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();	// テスト用
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
			.withUser("admin").password("admin").roles("ADMIN")
			.and()
			.withUser("user1").password("user1").roles("USER");
		
		auth
			.userDetailsService(userService)
			.passwordEncoder(getPasswordEncoder());		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and()
			.authorizeRequests()
				.antMatchers("/bookmarks").hasAuthority("ADMIN")
				.antMatchers("/tags").hasAuthority("USER")
				.anyRequest().authenticated();
//				.antMatchers("/**").hasRole("USER")
//				.and()
//				.csrf().disable()
//				.headers().frameOptions().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
