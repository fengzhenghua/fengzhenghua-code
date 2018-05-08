package com.hera.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *@authur fengzhenghua 2017年12月4日 下午8:53:41
 *@ClassName AspectDemo
 *@Describtion
 */
@Component
@Aspect
public class AspectDemo {
	
	//@Before(value = "execution(* com.hera.aspectj.PointDemo.point(..))")
	
//	public void before(JoinPoint joinPoint) {
//		System.out.println("befor call");
//	}
	@Pointcut("@annotation(com.hera.annotation.AnnotationAspect)")
	public void pointMethod() {
		
	}
	
	@AfterReturning(value="pointMethod()", returning="returnValue")
	public void afterRun(JoinPoint joinPoint , Object returnValue) {
		System.out.println("afterrunning 被执行");
	}
}	
