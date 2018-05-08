package com.hera.thingking.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@authur fengzhenghua 2017年11月11日 下午11:20:55
 *@ClassName RandomTimeTaskOut
 *@Describtion
 */
public class RandomTimeTaskOut {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5,new ThreadFactory() {
			
			AtomicInteger atomicInteger = new AtomicInteger(1000);
			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,"Thread-->"+atomicInteger.incrementAndGet());
			}
		});
		while(true) {
			exec.execute(new RunnableTask());
		}
		//exec.shutdown();
	}
}
	
	
class RunnableTask implements Runnable{
	
//	private static int name = 1000;
//	
//	static {
//		ThreadGroup group = Thread.currentThread().getThreadGroup();
//		Thread[] threads = new Thread[group.activeCount()];
//		group.enumerate(threads,false);
//		for(Thread t : threads) {
//			t.setName(String.valueOf(name++));
//		}
//	}
	
	
	private int id = 0;
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			int num = new Random().nextInt(10) + 1;
			try {
				TimeUnit.SECONDS.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ",sleep:" + num + "seconds" + ",id:" + id++);
			Thread.yield();
		}
		
	}
	
}
