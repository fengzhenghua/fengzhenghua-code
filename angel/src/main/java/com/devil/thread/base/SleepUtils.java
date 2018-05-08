package com.devil.thread.base;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月13日 下午6:39:08
 *@ClassName SleepUtils
 *@Describtion
 */
public class SleepUtils {
	
	public static final void second(long seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void convert() {
		long l = TimeUnit.NANOSECONDS.toMicros(1000);
		System.out.println(l);
	}
	
	@Test
	public void testInterExe() {
		try {
			Thread.sleep(5000);
			System.out.println(111);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


