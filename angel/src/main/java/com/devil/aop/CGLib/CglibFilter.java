package com.devil.aop.CGLib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 *@authur fengzhenghua 2017年12月4日 下午11:08:06
 *@ClassName CglibFilter
 *@Describtion
 */
public class CglibFilter implements CallbackFilter{

	@Override
	public int accept(Method arg0) {
		if(arg0.getName() == "get") {
			return 1;
		}
		return 0;
	}
	
	public void call(String a) {
		System.out.println("call" + a);
	}

}
