package com.devil.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

/**
 *@authur fengzhenghua 2018年3月12日 下午10:26:16
 *@ClassName Communication
 *@Describtion
 */
public class Communication {
	
	private static boolean flag = false;
	
	private static int i = 0;
	
	static Lock lock = new ReentrantLock();
	
	private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
	
	public static void main(String[] args) {
		
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				
				i++;
				if(flag) {
					System.out.println("do executor");
				}
				System.out.println(Thread.currentThread().getName());
			}
		}, 500, 500, TimeUnit.MILLISECONDS);
		
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				if(i > 10) {
					flag = true;
					System.out.println(Thread.currentThread().getName());
				}
				
			}
		}, 500, 500, TimeUnit.MILLISECONDS);
		
	}
	
	@Test
	public void test() throws InterruptedException {
		Task task = new Task(0);
		
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		thread1.start();
		thread2.start();
		thread3.start();
		//thread3.join();
		Thread.currentThread().join(500);//等待子线程走完后执行
		System.out.println("join结束");
	}
	
	private static class Task implements Runnable{
		
		private static int count = 0;
		
		public Task(int c) {
			count = c;
		}

		@Override
		public void run() {
			lock.lock();
			try {
				for(int k=0;k<1000;k++) {
					count ++;
					System.out.print(count + " "+ Thread.currentThread().getName() + " ");
				}
				System.out.println(count);
			}finally {
				lock.unlock();
			}
		}
	}
	
}
