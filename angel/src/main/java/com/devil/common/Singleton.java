package com.devil.common;

/**
 *@authur fengzhenghua 2017年10月9日 上午1:38:35
 *@ClassName Singleton
 *@Describtion
 */
public class Singleton {
	
	private static Singleton singleton;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		
		if(singleton == null) {
			synchronized (Singleton.class) {
				singleton = new Singleton();
			}
			
		}
		return singleton;
	}
	
	
}
