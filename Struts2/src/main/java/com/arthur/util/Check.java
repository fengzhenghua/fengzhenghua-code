package com.arthur.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Check {
	
	private static final String TOKEN="hua";
	
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = {TOKEN,timestamp,nonce};
		//排序
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			sb.append(arr[i]);
		}
		return getSha1(sb.toString()).equals(signature);
	}
	//sha1加密算法
	public static String getSha1(String str){
	    if (null == str || 0 == str.length()){
	        return null;
	    }
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	            'a', 'b', 'c', 'd', 'e', 'f'};
	    try {
	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
	        mdTemp.update(str.getBytes("UTF-8"));
	         
	        byte[] md = mdTemp.digest();
	        int j = md.length;
	        char[] buf = new char[j * 2];
	        int k = 0;
	        for (int i = 0; i < j; i++) {
	            byte byte0 = md[i];
	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
	            buf[k++] = hexDigits[byte0 & 0xf];
	        }
	        return new String(buf);
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	        return null;
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
}
