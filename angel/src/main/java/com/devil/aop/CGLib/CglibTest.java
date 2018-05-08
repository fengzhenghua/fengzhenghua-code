package com.devil.aop.CGLib;

/**
 *@authur fengzhenghua 2017年12月4日 下午11:11:08
 *@ClassName CglibTest
 *@Describtion
 */
public class CglibTest {
	
	public static void main(String[] args) {
		try {
			CglibProxy proxy = new CglibProxy();
			CglibFilter filter = (CglibFilter)proxy.getProxy(CglibFilter.class);
			filter.call("str");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
