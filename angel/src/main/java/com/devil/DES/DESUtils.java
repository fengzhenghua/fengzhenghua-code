package com.devil.DES;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils {
	
	//指定DES加密解密所用的秘钥
	private static Key key;
	private static String KEY_STR = "myKey";
	static{
		try{
			KeyGenerator generater = KeyGenerator.getInstance("DES");
			generater.init(new SecureRandom(KEY_STR.getBytes()));
			key = generater.generateKey();
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	//对字符串进行des加密，返回base64编码的加密字符串
	public static String getEncryptString(String str){
		BASE64Encoder base64en = new BASE64Encoder();
		try{
			byte[] StrByte = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(StrByte);
			return base64en.encode(encryptStrBytes);
		}catch(Exception e){
			throw new RuntimeException();
		}
	}
	
	//对base64编码的加密字符串解密，返回解密后的字符串
	public static String getDecryptString(String str){
		BASE64Decoder base64de = new BASE64Decoder();
		try{
			byte[] strByte = base64de.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrByte = cipher.doFinal(strByte);
			return  new String(decryptStrByte,"UTF8");
		}catch(Exception e){
		throw new RuntimeException();
		}
	}
	
	//对入参的字符串进行加密，打印出解密后的字符
	public static void main(String[] args) {
		System.out.println(getEncryptString("这是一个加密字符串"));
		System.out.println(getDecryptString(getEncryptString("这是一个加密字符串")));
	}
}	
