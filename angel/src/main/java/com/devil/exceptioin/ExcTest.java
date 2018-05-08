package com.devil.exceptioin;


import org.junit.Test;

/**
 *@authur fengzhenghua 2017年8月31日 下午8:35:35
 *@ClassName ExcTest
 *@Describtion
 */
public class ExcTest {
	
	@Test
	public void exce() {
		Class clazz = null;
		try {
			clazz = Class.forName("com.devil.hua.Feng");
		}catch (Exception e) {
			System.out.println("类未找到");
			clazz = ExcTest.class;
			throw new RuntimeException();
		}
		System.out.println(clazz.getName());
	}
	
	@Test
	public void runtime() {
		
		Integer num = null;
		int value = 0;
		try {
			num = new Integer(8);
			value = num / 0;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("除数不能为0");
			value = 2;
			//NullPointerException nu = null;
		}
		System.out.println(value);
		
	}

}
