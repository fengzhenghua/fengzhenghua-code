package com.hera.effective.obj;

import java.util.HashMap;
import java.util.Map;

/**
 *@authur fengzhenghua 2018年1月3日 上午1:43:22
 *@ClassName StrategyTest
 *@Describtion
 */
public class StrategyTest {
	
	
	public static int compareString(Stratety<String> ss) {
		return ss.compare("123", "1234");
	}
	
	public static void main(String[] args) {
		//int com = compareString(new StratetyImpl<>());
		//System.out.println(com);
		int a = 1;
		Map<String, Object> map = new HashMap<String, Object>();
		HashMap<String, Object> newMap = new HashMap<>();
		System.out.println(newMap instanceof Map);
		map.put("key", "value");
		Map<String, Object> destMap = map;
		System.out.println(map.hashCode());
		System.out.println(destMap.hashCode());
		System.out.println(a);
		System.out.println();
		//System.out.println(destMap.get("key"));
	}
}
