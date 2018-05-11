package com.mybookmark.mybookmarkapi.common.secure;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * セキュリティに関連した定数
 */
public class SecurityProperty {

	/** トークンプレフィックス */
	public static final String TOKEN_PREFIX = "Bearer ";
	
	/** シークレットキー */
	public static final String SECRET_KEY = "SecretKeyToGenJWTs";
	
	/** アルゴリズム */
	public static final SignatureAlgorithm SECURITY_ALGORITHM = SignatureAlgorithm.HS512;
	
	/** 有効期限(ms) */
	public static final int TOKEN_PERIOD = 10_800_000;
	
//	public static final int PERIOD = 0;
}
