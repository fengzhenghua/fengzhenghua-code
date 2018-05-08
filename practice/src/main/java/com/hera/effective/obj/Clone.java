package com.hera.effective.obj;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年12月3日 下午10:52:10
 *@ClassName Clone
 *@Describtion 必须实现Cloneable接口，否则报错
 */
public class Clone implements Cloneable{
	
	private int a ;
	private String b;
	
	public Clone(int a, String b) {
		this.a = a;
		this.b = b;
	}
	

	@Override
	protected Clone clone() throws CloneNotSupportedException {
		
		return (Clone)super.clone();
	}
	
	public static void main(String[] args) {
		Clone c1 = new Clone(2, "b");
		Clone c2 = null;
		try {
			c2 = c1.clone();
			System.out.println(c1.clone().equals(c1));
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c1);
		System.out.println(c2.a + " " + c2.b);
		System.out.println(c1 == c2);
		System.out.println(c1.getClass() == c2.getClass());
		System.out.println(c1.hashCode());
		System.out.println(c2.hashCode());
		
	}
}
