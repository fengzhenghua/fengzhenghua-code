package com.devil.common;

/**
 *@authur fengzhenghua 2017年10月19日 下午5:19:19
 *@ClassName InstanceOfTest
 *@Describtion
 */
public class InstanceOfTest {
	
	private static class Parent{
		
	}
	
	private static class Child extends Parent{
		
	}
	
	public static void main(String[] args) {
		
		Parent p = new Parent();
		Child c = new Child();
		boolean res;
		boolean res1;
		boolean res2;
		res = p instanceof Child;
		res1 = p instanceof Parent;
		res2 = c instanceof Parent;
		System.out.println(res);//父类对象不是子类的实例
		System.out.println(res1);
		System.out.println(res2);//子类对象是父类的实例
	}

}
