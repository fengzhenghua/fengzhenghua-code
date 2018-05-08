package com.devil.design;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
	
	public Map<String,Object> getMapFormFactory(){
		
		Map<String,Object> map = new HashMap<String,Object>();
		Properties properties = new Properties();
		InputStream in = PropertiesReader.class.getResourceAsStream("/jdbc.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Enumeration en = properties.propertyNames();
		while(en.hasMoreElements()){
			String key = (String) en.nextElement();
			map.put(key, properties.getProperty(key));
		}
		return map;
	}
}
