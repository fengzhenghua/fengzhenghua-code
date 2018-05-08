package com.hera.effective.obj.fanxing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *@authur fengzhenghua 2018年1月4日 上午3:00:08
 *@ClassName FanXingMethod
 *@Describtion
 */
public class FanXingMethod {
	
	public static <T extends List<? extends Map<String,Object>>> T getOne(List<? extends T> list){
		Iterator<? extends T> it = list.iterator();
		T t = it.next();
		while(it.hasNext()) {
			t = it.next();
		}
		return t;
	}
	
	public static void main(String[] args) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Map<String,Object> map = new HashMap<>();
		map.put("key", "value");
		list.add(map);
		//getOne();
	}
}
