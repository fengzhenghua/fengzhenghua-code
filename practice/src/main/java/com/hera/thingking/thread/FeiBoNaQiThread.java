package com.hera.thingking.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *@authur fengzhenghua 2017年11月12日 上午2:23:49
 *@ClassName FeiBoNaQiThread
 *@Describtion
 */
public class FeiBoNaQiThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++) {
			Future<String> ft = exec.submit(new FiBo(8));
			System.out.println(ft.get());
		}
		Future<String> future = new ThreadMethod().runTask(8);
		System.out.println(future.get());
	}
	
}
class FiBo implements Callable<String>{
long n = 0;
	
	public FiBo(int n) {
		this.n = n;
	}
	
	@Override
	public String call() throws Exception {
		return "第 n 个数字为：" + getSum2(n);
	}
	
	public long getSum2(long n) {
		long three = 0;
		long one = 1;
		long two = 1;
		for(int i=0;i<n-2;i++) {
			three = one + two;
			one = two;
			two = three;
		}
		return three;
		
	}
	
}
class ThreadMethod{
	
	public Future<String> runTask(int n){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		Future<String> ft = exec.submit(new FiBo(n));
		return ft;
	}
	
}
