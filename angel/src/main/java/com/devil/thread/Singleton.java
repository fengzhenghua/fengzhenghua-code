package com.devil.thread;


public class Singleton {
	
	//单例懒汉模式
	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance(){//双重检锁
		if(instance == null){
			synchronized (Singleton.class) {//加一个类锁
				instance = new Singleton();
			}
		}
		return instance;
	}
	
	//单例恶汉模式
/*private	class Singleton1{
		
		private static Singleton1 instance1 = new Singleton1();
		
		private Singleton1() {}
		
		public static Singleton getInstance1() {
			
			return instance1;
		}
		
	}*/
}
