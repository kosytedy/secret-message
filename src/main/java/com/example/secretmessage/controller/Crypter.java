package com.example.secretmessage.controller;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

public class Crypter {

	private static String key = "";
	private static final String initVector = "fvdhggFgGHSjnhSj";
	private static final byte[] salt = {69, 121, 101, 45, 62, 118, 101, 114, 61, 101, 98};
	
	public Crypter(String key) {
		Crypter.key = key;
	}
	
	public String encrypt(String message) {
		try {
			KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256);
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] key = f.generateSecret(spec).getEncoded();
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
			
			byte[] encrypted = cipher.doFinal(message.getBytes());
			
			return Base64.encodeBase64String(encrypted);
				
		} catch(Exception e){
			return e.getMessage();
		}
	}
	
	public String decrypt(String message) {
		try {
			KeySpec spec = new PBEKeySpec(key.toCharArray(), salt, 65536, 256);
			SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] key = f.generateSecret(spec).getEncoded();
			SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
			
			byte[] decrypted = cipher.doFinal(Base64.decodeBase64(message));
			
			return new String(decrypted);
				
		} catch(Exception e){
			return e.getMessage();
		}
	}

}
