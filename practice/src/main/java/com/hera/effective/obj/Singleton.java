package com.hera.effective.obj;

/**
 *@authur fengzhenghua 2018年4月19日 上午12:01:34
 *@ClassName Singleton
 *@Describtion
 */
public class Singleton {
	
	private static final Singleton singleton = new Singleton();
	
	private Singleton() {
		System.out.println("do execute");
		if(singleton != null)
			throw new UnsupportedOperationException();
	}
	
	public static Singleton getSingleton() {
		return singleton;
	}
	
	public static void main(String[] args) {
		Singleton s = getSingleton();
		System.err.println(s);
		//Singleton s = new Singleton();
	}
}
