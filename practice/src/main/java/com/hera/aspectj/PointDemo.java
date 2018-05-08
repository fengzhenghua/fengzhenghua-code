package com.hera.aspectj;

import org.springframework.stereotype.Component;

import com.hera.annotation.AnnotationAspect;
import com.hera.effective.obj.Person;

/**
 *@authur fengzhenghua 2017年12月4日 下午9:07:17
 *@ClassName PointDemo
 *@Describtion
 */

@Component
public class PointDemo {
	@AnnotationAspect
	public void point(Person person, int n, String str) {
		System.out.println("point被调用：" + person.getN() + " ," +  person.getStr() + "," + n + "," + str);
	}
}
