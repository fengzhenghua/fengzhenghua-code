package com.devil.thread.base;

import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年9月13日 下午6:37:07
 *@ClassName Interrupted
 *@Describtion
 */
public class Interrupted {
	
	public static void main(String[] args) throws InterruptedException {
		//sleepThread不停的尝试睡眠
		Thread sleepThread = new Thread(new SleepRunner(), "sleepThread");
		sleepThread.setDaemon(true);
		//busyThread不停的运行
		Thread busyThread = new Thread(new BusyRunner(),"bysyThread");
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		//休眠5秒,让sleepThread与busyThread充分运行
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();//未中断
		busyThread.interrupt();//busyThread已中断,处于非活动状态，再次中断起线程则会异常
		System.out.println("sleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println("busyThread interrupted is " + busyThread.isInterrupted());
		SleepUtils.second(2);
	}
	
	static class SleepRunner implements Runnable {

		@Override
		public void run() {
			while(true) {
				SleepUtils.second(10);//睡眠10秒
			}
		}
		
	}
	static class BusyRunner implements Runnable {

		@Override
		public void run() {
			while(true) {
				
			}
		}
		
	}
}
