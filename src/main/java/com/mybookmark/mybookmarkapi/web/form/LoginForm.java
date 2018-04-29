package com.mybookmark.mybookmarkapi.web.form;

public class LoginForm extends FormBean {

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
