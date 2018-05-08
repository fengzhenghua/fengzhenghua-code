package com.devil.thread.base;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年9月13日 下午9:43:15
 *@ClassName WaitNotify
 *@Describtion
 */
public class WaitNotify {
	public static boolean flag = true;
	public static Object lock = new Object();
	
	public static void main(String[] args) throws InterruptedException {
		Thread waitThread = new Thread(new Wait(),"WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(),"NotifyThread");
		notifyThread.start();
		
	}
	
	static class Wait implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {
				while(flag) {
					try {
						System.out.println(Thread.currentThread() + " flag is true . wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();//此时释放lock锁，lock同步代码块中程序暂停执行
					}catch (InterruptedException e) {
						
					}
				}
				//条件满足时，循环结束后，完成工作
				System.out.println(Thread.currentThread() + " flag is false. running @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		} 
		
	}
	
	static class Notify implements Runnable {

		@Override
		public void run() {
			synchronized (lock) {
				//获取lock的锁，然后进行通知，通知时不会释放lock的锁，
				//知道当前线程释放了lock后，WaitThread才能从wait方法中返回
				System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = true;
				SleepUtils.second(5);
			}
			//再次加锁
			synchronized(lock) {
				System.out.println(Thread.currentThread() + " hold lock again. sleep @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
		
	}
}
