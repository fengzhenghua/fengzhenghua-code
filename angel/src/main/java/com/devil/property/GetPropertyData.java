package com.devil.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertyData {
	
	public static void main(String[] args) {
		Properties pro = new Properties();
		InputStream in = GetPropertyData.class.getResourceAsStream("/jdbc.properties");
		try {
			pro.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			try {
				pro.load(in);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		String jdbcName = pro.getProperty("jdbc.username");
		System.out.println(jdbcName);
	}
}
