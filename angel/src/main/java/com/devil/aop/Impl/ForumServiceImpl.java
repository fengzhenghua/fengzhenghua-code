package com.devil.aop.Impl;

import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;

import com.devil.aop.service.ForumService;

public class ForumServiceImpl implements ForumService{

	public void removeTopic(int topicId) {
		//开始方法性能监视
		PerformanceMonitor.begin("com.devil.aop.Impl. removeTopic");
		System.out.println("模拟删除Topic记录："+topicId);
		try{
			Thread.currentThread().sleep(20);
		}catch(Exception e){
			throw new RuntimeException();
		}
		//结束方法监控
		PerformanceMonitor.end();
	}

	public void removeForum(int fourumId) {
		PerformanceMonitor.begin("com.devil.aop.Impl. removeForum");
		System.out.println("模拟删除forum记录："+fourumId);
		try{
			Thread.currentThread().sleep(40);
		}catch(Exception e){
			throw new RuntimeException();
		}
		PerformanceMonitor.end();
	}
		
}
