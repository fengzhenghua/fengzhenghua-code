package com.hera.thingking.thread;

/**
 *@authur fengzhenghua 2018年1月10日 上午12:56:22
 *@ClassName ThreadChangeSelf
 *@Describtion
 */
public class ThreadChangeSelf {
	
	Integer integer = new Integer(5);
	
	static int a = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0 ; i<1000000000;i++) {
					a++ ;
				}
				System.out.println(a);
			}
			
		});
		t.start();
		//t.join();
		//t.yield();
		System.out.println(a);
	}
}
