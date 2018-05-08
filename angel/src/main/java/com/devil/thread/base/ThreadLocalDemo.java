package com.devil.thread.base;

import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年9月16日 下午7:28:11
 *@ClassName ThreadLocalDemo
 *@Describtion
 */
public class ThreadLocalDemo {
	
	private static final ThreadLocal<Long> local = new ThreadLocal<Long>();
	
	public static void main(String[] args) throws InterruptedException {
		ThreadLocalDemo.begin();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Cost:" + ThreadLocalDemo.end() + " mills");
		//sThreadLocalDemo.end();
	}
	
	public static void begin() {
		local.set(System.currentTimeMillis());
	}
	
	public static long end() {
		return System.currentTimeMillis() -  local.get();
	}
	
}
