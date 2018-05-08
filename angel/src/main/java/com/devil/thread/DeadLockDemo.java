package com.devil.thread;

/**
 *@authur fengzhenghua 2017年9月13日 下午12:23:24
 *@ClassName DeadLockDemo
 *@Describtion
 */
public class DeadLockDemo {
	
	private static String A = "A";
	private static String B = "B";
	
	public static void main(String[] args) {
		new DeadLockDemo().deadLock();
	}
	
	public void deadLock() {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (A) {
					try {
						Thread.currentThread().sleep(2000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (B) {
						System.out.println("1");
					}
				}
			}
			
		});
		
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (B) {
					synchronized (A) {
						
					}
				}
			}
			
		});
		
		t1.start();
		t2.start();
	}
}
