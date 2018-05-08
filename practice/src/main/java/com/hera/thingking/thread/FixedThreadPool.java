package com.hera.thingking.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *@authur fengzhenghua 2017年11月11日 上午1:09:58
 *@ClassName FixedThreadPool
 *@Describtion
 */
public class FixedThreadPool {
	
	public static void main(String[] args) {
		//ExecutorService executor = Executors.newFixedThreadPool(5);//固定线程数
		//ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorService executor = Executors.newSingleThreadExecutor(new ThreadFactory() {
			
			AtomicInteger ai = new AtomicInteger(100);
			
			@Override
			public Thread newThread(Runnable r) {
				return new Thread(r,String.valueOf("name-" + ai));
			}
			
		});//单个线程
		for(int i=0;i<8;i++) {
			executor.execute(new LiftOff());
		}
		executor.shutdown();
	}
}
