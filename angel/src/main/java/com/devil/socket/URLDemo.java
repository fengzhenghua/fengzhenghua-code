package com.devil.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.baidu.com");
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		InputStream in =url.openStream();
		Reader reader = new InputStreamReader(in);
		BufferedReader bfr = new BufferedReader(reader);
		String data = bfr.readLine();
		while(data != null){
			System.out.println(data);
			data = bfr.readLine();
		}
		bfr.close();
	}
}
