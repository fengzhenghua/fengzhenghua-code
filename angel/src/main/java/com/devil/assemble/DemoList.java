package com.devil.assemble;

import java.util.HashSet;
import java.util.Vector;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月7日 上午12:48:33
 *@ClassName DemoList
 *@Describtion
 */
public class DemoList {
	
	/**
	 * Vector是线程安全，可以有重复元素
	 * 去除Vector中重复的元素
	 */
	@Test
	public void testVector() {
		Vector<String> v = new Vector<String>();
		Vector<String> newV = new Vector<String>();
		v.add("abc");
		v.add("xyz");
		v.add("abc");
		for(int i=0;i<v.size();i++) {//拿一个新的容器来装
			String str = v.get(i);
			
			if(!newV.contains(str)) {
				newV.add(str);
			}
		}
		
		for(int j=0;j<newV.size();j++) {//遍历新容器
			System.out.println(newV.get(j));
		}
//		HashSet<String> hs = new HashSet<String>(v);
//		
//		for(String s : hs) {
//			System.out.println(s);
//		}
	}
}
