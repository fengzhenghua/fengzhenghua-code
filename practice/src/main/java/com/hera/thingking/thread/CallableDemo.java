package com.hera.thingking.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年11月11日 下午10:50:23
 *@ClassName CallableDemo
 *@Describtion
 */
public class CallableDemo {
	static int k = 0;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService exec = Executors.newCachedThreadPool();
		//ScheduledThreadPoolExecutor execs = Executors.newScheduledThreadPool(10)
		//execs.
		ScheduledThreadPoolExecutor execs = new ScheduledThreadPoolExecutor(10);
		execs.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				//System.out.println("do");
				//boolean flag = false;
//				while(flag) {
//					execs.shutdown();
//				}
				k ++;
				System.out.println(k);
				if(k == 5) {
					execs.shutdown();
				}
				
				
			}
		}, 0, 5, TimeUnit.MILLISECONDS);
		
		/*List<Future<String>> resurts = new ArrayList<Future<String>>();
		for(int i=0;i<10;i++) {
			resurts.add(exec.submit(new TaskWithResurt(i)));
		}
		for(Future<String> fs : resurts) {
			try {
				System.out.println(fs.get());
			}catch (Exception e) {
				System.out.println(e);
				return;
			}finally {
				exec.shutdown();
			}
		}*/
//		boolean flag = true;
//		int i=1;
//		while(flag) {
//			Future<Integer> task = exec.submit(new TaskWithResurt(i++));
//			if(task.get() == 5) {
//				flag = false;
//			}
//			System.out.println(task.get());
//		}
	}
	
}
class TaskWithResurt implements Callable<Integer>{
	
	private int id;
	
	public TaskWithResurt(int id) {
		this.id = id;
	}
	
	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return id;
	}
	
}
class TaskWithResurtBool implements Callable<Boolean>{
	
	private boolean flag;	
	public TaskWithResurtBool(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public Boolean call() throws Exception {
		return flag;
	}
	
}
