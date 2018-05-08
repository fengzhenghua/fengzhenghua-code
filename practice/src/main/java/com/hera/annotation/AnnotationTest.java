package com.hera.annotation;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年12月5日 上午12:47:26
 *@ClassName AnnotationTest
 *@Describtion
 */
public class AnnotationTest {
	
	@AnnotationAspect(string = "测试" ,intmethod = 1234)
	public void method() {
		System.out.println("method");
	}
	
	@Test
	public void anTest() throws NoSuchMethodException, SecurityException {
		AnnotationAspect an = null;
		if(this.getClass().getMethod("method").isAnnotationPresent(AnnotationAspect.class)) {
			an = this.getClass().getMethod("method").getAnnotation(AnnotationAspect.class);
		}
		System.out.println(an.string());
		System.out.println(an.intmethod());
	}
}
