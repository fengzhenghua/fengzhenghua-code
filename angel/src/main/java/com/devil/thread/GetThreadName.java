package com.devil.thread;

public class GetThreadName {
	
	public synchronized void Method1(){
		try {
			System.out.println(Thread.currentThread().getName());
			//System.out.println(Thread.currentThread().getId());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public synchronized void Method2(){
		System.out.println(Thread.currentThread().getName());
		//System.out.println(Thread.currentThread().getId());
	}
	
	public static void main(String[] args) {
		
		final GetThreadName gtn = new GetThreadName();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				gtn.Method1();
			}
		},"t1");
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				gtn.Method2();
			}
		},"t2");
		t1.start();
		t2.start();
	}
}
