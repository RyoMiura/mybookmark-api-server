package com.mybookmark.mybookmarkapi.common.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mybookmark.mybookmarkapi.web.util.converter.DtoFormMapper;

@Configuration
//@ComponentScan("com.mybookmark.mybookmarkapi")
public class ApplicationConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
