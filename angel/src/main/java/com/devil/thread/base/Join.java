package com.devil.thread.base;

import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年9月16日 下午7:02:14
 *@ClassName Join
 *@Describtion
 */
public class Join {
	
	public static void main(String[] args) throws InterruptedException {
		Thread previous = Thread.currentThread();
		for(int i=0;i<10;i++) {
			//每个线程拥有前一个线程的引用，需要等待前一个线程
			Thread thread = new Thread(new Domino(previous),String.valueOf(i));
			thread.start();
			previous = thread;
		}
		TimeUnit.SECONDS.sleep(1);
		System.out.println(Thread.currentThread().getName() + " terminate");
		
	}
	
	static class Domino implements Runnable {
		private Thread thread;

		public Domino(Thread thread) {
			super();
			this.thread = thread;
		}

		@Override
		public void run() {
			try {
				thread.join();//后一个等待前一个进程执行从此处返回。
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() +" terminate.");
		}
		
		
	}
}
