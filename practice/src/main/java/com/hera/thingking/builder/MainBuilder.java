package com.hera.thingking.builder;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年11月25日 上午12:14:28
 *@ClassName MainBuilder
 *@Describtion
 */
public class MainBuilder {
	
	@Test
	public void bTest() {
		Effective effective = new Effective.Builder("kangkang", "8888888888888888").age(18).high(15.0).addMap("key", "value").build();
		System.out.println(effective.getAge());
		System.out.println(effective.getMap().get("key"));
		
		Effective.Builder builder = Effective.newBuilder();
		builder.money("666").age(33).high(22.0);
		Effective e = builder.build();
		System.out.println(e.getAge());
		System.out.println(e.getHigh());
		
		//Effective e2 = Effective.newBuilder().build(builder)
	}
}
