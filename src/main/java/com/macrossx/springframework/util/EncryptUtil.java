/**
 * Copyright (C) 2016 X-Forever.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.macrossx.springframework.util;

import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class EncryptUtil {
	public static final Charset UTF_8 = Charset.forName("UTF-8");

	// In fact we should use PKCS7, but java standard only support PKCS5.
	// PKCS5 is a subset of PKCS7, in practice these two can be used
	// interchangeably, so let us try this.
	private static final String CIPHER_AES = "AES/CBC/PKCS5Padding";

	private static final int CIPHER_KEY_LENGTH = 128;
	private static final int CIPHER_IV_LENGTH = 128;

	/**
	 * AES加密
	 */
	public static String encryptAES(byte[] content, SecretKeySpec sKey, IvParameterSpec sIv) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_AES);// 创建密码器
			cipher.init(Cipher.ENCRYPT_MODE, sKey, sIv);// 初始化
			return Base64.getUrlEncoder().encodeToString(cipher.doFinal(content));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String encryptAESString(String content, SecretKeySpec sKey, IvParameterSpec sIv) {
		return encryptAES(content.getBytes(UTF_8), sKey, sIv);
	}

	/**
	 * AES解密
	 */
	public static byte[] decryptAES(String base64UrlContent, SecretKeySpec sKey, IvParameterSpec sIv) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_AES);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, sKey, sIv);// 初始化
			return cipher.doFinal(Base64.getUrlDecoder().decode(base64UrlContent));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static byte[] decryptAES(byte[] content, SecretKeySpec sKey, IvParameterSpec sIv) {
		try {
			Cipher cipher = Cipher.getInstance(CIPHER_AES);// 创建密码器
			cipher.init(Cipher.DECRYPT_MODE, sKey, sIv);// 初始化
			return cipher.doFinal(content);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String decryptAESString(String content, SecretKeySpec sKey, IvParameterSpec sIv) {
		return new String(decryptAES(content, sKey, sIv), UTF_8);
	}

	public static byte[] generateAESKey(String secretKey) throws NoSuchAlgorithmException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(CIPHER_KEY_LENGTH, new SecureRandom(secretKey.getBytes(UTF_8)));
		return kgen.generateKey().getEncoded();
	}

	public static byte[] generateAESIV(String secretKey) throws NoSuchAlgorithmException {
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		kgen.init(CIPHER_IV_LENGTH, new SecureRandom(secretKey.getBytes(UTF_8)));
		return kgen.generateKey().getEncoded();
	}
	
	public static void main(String ...s){
		String sessionkey="8W5oj94xn/yt7Hg5BipAYw==";
		String data="cz3RGvlwIgo6Lbe878tPLEzR9TbXzMWd1e257WOtkBqrxqxBYiUeylOMAHfbA7S3MCmUHMJEIri82qKWvv4RQWgo/VZrSeFldYBkfJIl2C+7r6j8E8HgX+bHTJk7bDz/Ge2Mt65uzj4z6KNMqTEPEwgFQmcKTy2KFF1LqCuCC7RagFCfig60f49iZAgPNuzEzN3SwV2JhelCuZE2/zxVTQxa/j79NCsWqTLdBQ5QBCcrKUUx/Oc547k7BTCKjLtMIZHakAgr5euSLM1pMtGNoem//gGvAiRIsHlTC+vjwMJxeCMqBGeC7usxUEiJ1n51D3wUW8/3Wb7eI88/Y5cPyomH/mxfegcmeMqEol8zqXsHqMK5+Ymh3HDhowIsR5mt2K80TWFwtYyGB7QzQRRs2ocWPPu4ZRib0gMPaSmkP8/M2iq+Tqi70N7mS57weDpzOHKl+GHVkFAgv/Gpt06APA==";
		String siv="4T1Z6TCFoSQSTBtt6yDatg==";
		System.out.println("1");
		byte[] sk = Base64.getDecoder().decode(sessionkey);
		System.out.println("2");
		byte[] content = Base64.getDecoder().decode(data);
		System.out.println("3");
		byte[] iv = Base64.getDecoder().decode(siv);
		System.out.println("4");
		SecretKeySpec sKey = new SecretKeySpec(sk, "AES");
		IvParameterSpec sIv = new IvParameterSpec(iv);
		System.out.println(new String(	EncryptUtil.decryptAES(content, sKey, sIv)	));	
		
	}
}
