package com.devil.string;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月6日 上午12:25:00
 *@ClassName StringTest
 *@Describtion
 */
public class StringTest {
	
	@Test
	public void testString() {
		/**
		 * 当创建a,b对象时，a,b的引用指向同一块内存地址，而a和c不是，c另外分配了一块内存，相当于建立了两个对象
		 * 
		 */
		String a = "abc";
		String b = "abc";
		String c = new String("abc");
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a.equals(c));//此时a与c相等，equals方法是比较两个对象内容是否相等，而非内存地址
		
	}
	
	@Test
	public void stringTest() {
		String str = "abcdefghi";
		String str1 = "ABcdefGhi";
		boolean flag = str.startsWith("cde", 2);
		System.out.println(flag);
		String t = String.copyValueOf(str.toCharArray());
		System.out.println(t);
		System.out.println(str.compareToIgnoreCase(str1));
	}

}
