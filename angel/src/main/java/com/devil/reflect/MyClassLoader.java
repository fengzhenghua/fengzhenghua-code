package com.devil.reflect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader {
	
	public static void main(String[] args) throws IOException {
		
		ClassLoader cl1 = MyClassLoader.class.getClassLoader();
		ClassLoader cl2 = Thread.currentThread().getContextClassLoader();
		System.out.println(cl1==cl2);//返回True
		ClassLoader loader = cl1.getParent();
		System.out.println(loader.getClass().getName());
		InputStream in = MyClassLoader.class.getResourceAsStream("/file1.txt");
		//InputStream in = cl2.getResourceAsStream("/file1.txt");//不能获取，in=null
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		int n = 0;
		while((n=in.read())!=-1){
			out.write(n);
		}
		System.out.println(out.toString());
	}
}
