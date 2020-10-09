package com.example.secretmessage.controller;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Crypter {

	private static String key = "";
	private static final String initVector = "fvdhggFgGHSjnhSjJHSb";
	
	public Crypter(String key) {
		Crypter.key = key;
	}
	
	public String encrypt(String message) {
		try {
				IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
				SecretKeySpec sKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
				cipher.init(Cipher.ENCRYPT_MODE, sKeySpec, iv);
				
				byte[] encrypted = cipher.doFinal(message.getBytes());
				
				return Base64.encodeBase64String(encrypted);
				
		} catch(Exception e){
			return e.getMessage();
		}
	}
	
	public String decrypt(String message) {
		try {
				IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
				SecretKeySpec sKeySpec = new SecretKeySpec(key.getBytes(), "AES");
				
				Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
				cipher.init(Cipher.DECRYPT_MODE, sKeySpec, iv);
				
				byte[] decrypted = cipher.doFinal(Base64.decodeBase64(message));
				
				return new String(decrypted);
				
		} catch(Exception e){
			return e.getMessage();
		}
	}

}
