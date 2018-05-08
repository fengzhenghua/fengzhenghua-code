package com.devil.design;

import java.util.Map;

public class AnimalFactory {
	
	public  AnimalDFactoryInterface getAnimal(String key){
		
		try {
			Map<String,Object> map = new PropertiesReader().getMapFormFactory();
			AnimalDFactoryInterface animal = (AnimalDFactoryInterface) Class.forName(map.get(key).toString()).newInstance();
			return animal;
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
