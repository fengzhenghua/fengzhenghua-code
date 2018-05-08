package com.hera.thingking.thread;

import java.util.concurrent.CountDownLatch;

/**
 *@authur fengzhenghua 2017年11月11日 上午1:12:51
 *@ClassName LiftOff
 *@Describtion
 */
public class LiftOff implements Runnable{
	
	protected int countDown = 10;
	private static int taskCount = 0;
	private int id = taskCount++;
	
	public LiftOff() {}
	public LiftOff(int countDown) {
		this.countDown = countDown;
	}
	
	public String status() {
		return "#" + id + Thread.currentThread().getName() + "(" +
	(countDown > 0 ? countDown : "Liftoff") + "),";
	}
	@Override
	public void run() {
		while(countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
	}

}
