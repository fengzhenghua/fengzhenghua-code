package com.devil.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapTest {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("1","aa");
		map.put("2", "bb");
		map.put("3", "cc");
		Iterator it = map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Object> mapStr = (Entry<String, Object>) it.next();
			System.out.println(mapStr.getValue());
		}
		Set sets = map.keySet();
		for(Object obj :sets){
			System.out.println(map.get(obj));
		}
	}
}
