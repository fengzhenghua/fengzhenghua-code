package com.devil.io;

import java.io.CharArrayReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月21日 上午3:26:50
 *@ClassName IOTest
 *@Describtion
 */
public class IOTest {
	
	
	@Test
	public void stringReader() throws IOException {
		//String str = "abcdefghijklmnopqrstuvwxyz";
		StringReader sr = new StringReader("正华abcdefghijklmnopqrstuvwxyz");
		int n = 0;
		String s = "";
		while((n=sr.read()) != -1) {
			s = s + (char)n;
		}
		System.out.println(s);
	}
	
	@Test
	public void charArrayReader() throws IOException {
		
		CharArrayReader car = new CharArrayReader("正华abcdefghijklmnopqrstuvwxyz".toCharArray());
		int n = 0;
		String s = "";
		while((n=car.read()) != -1) {
			s = s + (char)n;
		}
		System.out.println(s);
	}
}
