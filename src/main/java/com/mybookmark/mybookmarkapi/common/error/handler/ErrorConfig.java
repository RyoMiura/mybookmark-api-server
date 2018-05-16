package com.mybookmark.mybookmarkapi.common.error.handler;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * spring の java configuration クラス
 */
@Configuration
public class ErrorConfig {

	@Bean
	public ErrorAttributes errorAttributes() {
		return new ApplicationErrorAttributes();
	}
}
