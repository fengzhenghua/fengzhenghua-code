package com.hera.effective.obj.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 *@authur fengzhenghua 2018年1月5日 上午2:08:54
 *@ClassName LimitTongPei
 *@Describtion
 */
public class LimitTongPei {
	
	public static void swap(List<?> list, int i, int j) {
		
		swapHelper(list, i ,j);
	}
	
	private static <E> void swapHelper(List<E> list, int i, int j) {
		list.set(i, list.set(j, list.get(i)));
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("Str");
		swap(list, 0, 0);
	}
}
