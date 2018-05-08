package com.devil.seralize;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *@authur fengzhenghua 2017年8月28日 下午11:40:41
 *@ClassName SeraTest
 *@Describtion
 */
public class SeraTest {
	
	private long beforeTime;
	private long endTime;
	
	@Before
	public void getBefore() {
		beforeTime = System.currentTimeMillis();
		System.out.println("开始");
	}
	
	@Test
	public void seralizeTest() {
		//SeralizTool tool = new SeralizTool();
		Person person = new Person("xiaoming",22,"boy");
		byte[] bytes = SeralizTool.seralize(person);
		System.out.println(bytes);
		
	}
	
	public byte[] getBytes() {
		Person person = new Person("xiaoming",22,"boy");
		byte[] bytes = SeralizTool.seralize(person);
		return bytes;
	}
	
	@Test
	public void toObjTest() {
		Object obj = SeralizTool.byteToObj(getBytes());
		Person person = (Person) obj;
		System.out.println(person.getName()+person.getAge()+person.getSex());
	}
	
	@After
	public void getEnd() {
		endTime = System.currentTimeMillis();
		System.out.println("结束");
		System.out.println(endTime - beforeTime);
	}
	
	@Test
	public void mapTest() {
		Person per = new Person("man",22,"boy");
		Map<String, Person> map = new HashMap<>();
		map.put("p1", per);
		
		per.setAge(33);
		//Person p = map.get("p1");
		//p.setAge(33);
		
		System.out.println(map.get("p1").getAge());
	}
	
}	
