package com.devil.thread;

/**
 *@authur fengzhenghua 2017年9月1日 下午2:49:25
 *@ClassName Concurrencytest
 *@Describtion
 */
public class Concurrencytest {
	
	public static final long count = 10000001;
	
	public static void main(String[] args) throws InterruptedException {
		concurrency();
		serial();
	}
	/**
	 * 并行
	 * @throws InterruptedException
	 */
	public static void concurrency() throws InterruptedException {
		//开始时间
		long start = System.currentTimeMillis();
		//定义一个线程
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				int a = 0;
				for(long i=0;i<count;i++) {
					a += 5;
				}
			}
			
		});
		thread.start();
		int b = 0;
		for(long i = 0;i < count; i++) {//次循环与上面线程循环并行执行
			b--;
		}
		thread.join();//子线程执行完后进入下面执行
		long time = System.currentTimeMillis() - start;
		System.out.println("concurrenty :" + time +"ms,b=" + b);
	}
	
	/**
	 * 串行
	 */
	private static void serial() {
		long start = System.currentTimeMillis();
		int a = 0;
		for(long i=0;i<count;i++) {
			a += 5;
		}
		int b = 0;
		for(long i=0;i< count;i++) {
			b--;
		}
		long time = System.currentTimeMillis() - start;
		System.out.println("serial:"+time+"ms,b="+b+",a="+a);
	}
	
}
