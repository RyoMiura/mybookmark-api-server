package com.mybookmark.mybookmarkapi.common.secure;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupForm {
	
	@NotBlank
	@Size(min = 4, max=20)
	@Pattern(regexp = "[a-zA-Z0-9\\-]*")
	private String loginId;
	
	@NotBlank
	@Size(min = 4, max=30)
	@Pattern(regexp = "[a-zA-Z0-9\\-]*")
	private String password;

	
	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
