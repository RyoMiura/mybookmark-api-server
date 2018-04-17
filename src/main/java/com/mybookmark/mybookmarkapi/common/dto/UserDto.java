package com.mybookmark.mybookmarkapi.common.dto;

public class UserDto extends DtoBean {
	
	private long userId;	
	private String loginId;
	private String password;
	
	public UserDto() {
	}
	
	public long getUserId() {
		return userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
