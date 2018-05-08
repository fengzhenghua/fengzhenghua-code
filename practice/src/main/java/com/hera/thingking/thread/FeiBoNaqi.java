package com.hera.thingking.thread;

/**
 *@authur fengzhenghua 2017年11月12日 上午1:44:56
 *@ClassName FeiBoNaqi
 *@Describtion
 */
public class FeiBoNaqi {
	
	
	public long getSum1(long n) {
		if(n==1 || n==2) {
			return 1;
		}
		return getSum1(n-1) + getSum1(n-2);
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
	
	public static void main(String[] args) {
		FeiBoNaqi fb = new FeiBoNaqi();
//		long t1 = System.currentTimeMillis();
//		System.out.println(fb.getSum1(45));
//		System.out.println(System.currentTimeMillis() - t1);
		long t2 = System.currentTimeMillis();
		System.out.println(fb.getSum2(100));
		System.out.println(System.currentTimeMillis() - t2);
	}
}
