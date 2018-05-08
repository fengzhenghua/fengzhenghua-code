package com.hera.thingking;

import java.util.LinkedList;

import org.junit.Test;

/**
 *@authur fengzhenghua 2018年2月21日 下午11:26:20
 *@ClassName LinkedArrayListTest
 *@Describtion
 */
public class LinkedArrayListTest {
	
	@Test
	public void test() {
		LinkedList<Integer> lkl = new LinkedList<>();
		for(int i=0;i<10;i++) {
			lkl.add(i);
		}
		lkl.remove(3);
		for(Integer in : lkl) {
			System.out.println(in);
		}
		Integer ig = 10;
		Integer k = ig;
		ig = null;
		System.out.println(k);
		System.out.println(ig);
	}
	
//	@Test
//	public void 

}
