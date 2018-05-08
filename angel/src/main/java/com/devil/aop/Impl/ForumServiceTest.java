package com.devil.aop.Impl;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.devil.aop.service.ForumService;

public class ForumServiceTest {
	@Test
	public void proxy(){
		ForumService target = new ForumServiceImpl();
		PerformanceHandler handler = new PerformanceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), handler);
		proxy.removeForum(10);
		proxy.removeTopic(1012);
	}
}
