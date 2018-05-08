package com.devil.assemble;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

/**
 *@authur fengzhenghua 2017年9月5日 下午7:05:57
 *@ClassName DemoMap
 *@Describtion
 */
public class DemoMap {
	
	
	
	@Test
	public void testTreeMap() {
		
		SortedMap<String, Object> smap = new TreeMap<String,Object>();
		smap.put("first", "no1");
		smap.put("second", "no2");
		smap.put("third", "no3");
		System.out.format("第一个map:%s", smap.firstKey());
		System.out.println();
		System.out.format("第二个map:%s", smap.lastKey());
		System.out.println();
		System.out.println(smap.subMap("first", "third"));//截取前两者，不包含第三者
		
		
	}
	
	@Test
	public void testHashTable() throws IOException {
		
		Hashtable<String,Object> ht = new Hashtable<String,Object>();
		InputStream in = new ClassPathResource("jdbc.properties").getInputStream();
		Properties properties = new Properties();
		properties.load(in);
		properties.put("ls", "详情");
		ht.put("aa", "bb");
		System.out.println(ht.get("aa"));
		System.out.println(properties.get("Dog"));
		System.out.println(properties.get("ls"));
	}
	
	enum Operate{
		
		INSERT,UPDATE,DELETE;
	}
	
	
	@Test
	public void testEnumMap() {
		
		Map<Operate,Object> map = new EnumMap<Operate,Object>(Operate.class);
		map.put(Operate.INSERT, "insertOperate");
		map.put(Operate.UPDATE, "UpdateOperate");
		map.put(Operate.DELETE, "DeleteOperate");
		Set<Operate> sets = map.keySet();
		
		for(Operate o : sets) {
			System.out.println(o.name());
			System.out.println();
		}
		//System.out.println(map);
		
	}
	/**
	 * 遍历map有三种形式，一是获取key集合keySet()方法，二是
	 */
	
	@Test
	public void testEntryTest() {
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("one", "first");
		map.put("two", "second");
		map.put("three", "third");
		Set<String> set = map.keySet();
		Collection<Object> list =  map.values();//如果向下转型为list则报错，向下转型不安全性
		//遍历list
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//System.out.println(list.toString());
		Set<Map.Entry<String, Object>> mapEntry = map.entrySet();
		for(Map.Entry<String, Object> me : mapEntry) {
			System.out.println(me.getKey()+ " " + me.getValue());
		}
	}
}
