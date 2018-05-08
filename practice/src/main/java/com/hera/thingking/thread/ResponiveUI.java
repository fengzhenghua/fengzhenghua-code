package com.hera.thingking.thread;

import java.io.IOException;

/**
 *@authur fengzhenghua 2017年11月13日 上午12:07:55
 *@ClassName ResponiveUI
 *@Describtion
 */
public class ResponiveUI extends Thread{
	private static volatile double d = 1;
	public ResponiveUI() {
		setDaemon(true);
		start();
	}
	public void run() {//把执行放在run()方法里面，程序可以得到终止
		while(true) {
			d = d + (Math.PI + Math.E);
		}
	}
	public static void main(String[] args) throws IOException {
		new UnresponsiveUI();
		new ResponiveUI();
		System.in.read();
		System.out.println(d);
	}
}
class UnresponsiveUI{
	private volatile double d = 1;
	public UnresponsiveUI() throws IOException {
		while(d>0) {
			d = d + (Math.PI + Math.E) / d;//程序将一直运行下去，得不到终止。
			System.in.read();
		}
	}
}
