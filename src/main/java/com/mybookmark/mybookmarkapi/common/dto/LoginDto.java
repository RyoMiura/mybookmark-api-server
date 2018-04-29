package com.mybookmark.mybookmarkapi.common.dto;

public class LoginDto extends DtoBean {

	private String loginId;
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
