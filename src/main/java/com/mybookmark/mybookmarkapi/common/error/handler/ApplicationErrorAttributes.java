package com.mybookmark.mybookmarkapi.common.error.handler;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * Internal Server Error 発生時のレスポンスデータに表示させる内容を調整するための設定。
 */
public class ApplicationErrorAttributes extends DefaultErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
		errorAttributes.remove("exception");
		errorAttributes.remove("message");
		return errorAttributes;
	}
	
}
