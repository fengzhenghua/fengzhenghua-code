package com.hera.practice;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *@authur fengzhenghua 2017年12月18日 上午1:28:27
 *@ClassName Sigleton
 *@Describtion
 */
public class Sigleton {
	
	private String str;
	
	private static class  SigletonSub{
		public static Sigleton instance = new Sigleton();
	}
	
	private static Sigleton getInstance() {
		return SigletonSub.instance;
	}
	
	public static void main(String[] args) throws UnknownHostException {
		Sigleton.getInstance().setStr("test");
		String str = Sigleton.getInstance().getStr();  
		System.out.println(str);
		InetAddress remote = InetAddress.getByName("39.106.56.211");
		String shebeiName = remote.getHostName();
		System.out.println(shebeiName);
		
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
}
