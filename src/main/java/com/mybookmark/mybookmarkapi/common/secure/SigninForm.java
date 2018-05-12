package com.mybookmark.mybookmarkapi.common.secure;

/**
 * singnin用フォーム。
 */
public class SigninForm {

	/** ログインID */
	private String loginId;

	/** パスワード */
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
