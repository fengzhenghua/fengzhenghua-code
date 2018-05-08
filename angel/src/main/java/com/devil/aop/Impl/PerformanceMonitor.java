package com.devil.aop.Impl;

public class PerformanceMonitor {
	
	//1.通过一个ThreadLocal保存与调用线程相关的性能监视信息
	private static ThreadLocal<MethodPerformance> performanceRecord = new ThreadLocal<MethodPerformance>();
	
	//2.启动对某一目标方法的性能监视
	public static void begin(String method){
		System.out.println("begin monitor...");
		MethodPerformance mp = new MethodPerformance(method);
		performanceRecord.set(mp);
	}
	
	public static void end(){
		System.out.println("end monitor..");
		MethodPerformance mp = performanceRecord.get();
		mp.printPerformance();
	}
}
