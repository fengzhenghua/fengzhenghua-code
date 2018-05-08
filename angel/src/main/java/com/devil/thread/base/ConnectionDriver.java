package com.devil.thread.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年9月16日 下午8:11:55
 *@ClassName ConnectionDriver
 *@Describtion
 */
public class ConnectionDriver {
	static class ConnectionHandler implements InvocationHandler {

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//调用到method=commit时
			if(method.getName().equals("commit")) {
				TimeUnit.MILLISECONDS.sleep(101);
				//System.out.println(Thread.currentThread().getName());
			}
			return null;
		}
		
	}
	
	//创建一个Connection 的代理对象，在commit时休眠100毫秒
	public static final Connection createConnection() {
		return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), 
				new Class<?>[] {Connection.class}, new ConnectionHandler());
	}
}
