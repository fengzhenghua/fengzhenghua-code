package com.devil.thread;

import java.util.Calendar;

public class MultiThread {
	
	private static int num;
	public  synchronized static void  printNum(String tag) throws InterruptedException{
		if(tag.equals("a")){
			num = 100;
			System.out.println("tag a ,set num over");
			Thread.sleep(1000);
		}else{
			num = 200;
			System.out.println("tag b ,set num over");
		}
		System.out.println("tag="+tag+" num="+num);
	}
	public static void main(String[] args) {
		
		final MultiThread t1 = new MultiThread();//t1,t2每个对象一把锁，如果把main方法变为static静态方法，锁级别为类，一把锁，线程安全。
		final MultiThread t2 = new MultiThread();
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t1.printNum("a");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					t2.printNum("b");
				} catch (InterruptedException e) {
				}
			}
		});
		
		thread1.start();//两个线程同时执行。
		thread2.start();
		//Calendar c
	}
}
