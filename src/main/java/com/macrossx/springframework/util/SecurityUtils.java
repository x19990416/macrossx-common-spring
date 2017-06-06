package com.macrossx.springframework.util;

import com.google.common.hash.Hashing;

public class SecurityUtils {
	public static String MD5(String message){
		return  Hashing.md5().newHasher().putBytes(message.toString().getBytes()).hash().toString();
	}
}
