package com.hera.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.lang.model.element.Element;

/**
 *@authur fengzhenghua 2017年12月4日 下午10:20:14
 *@ClassName AnnotationAspect
 *@Describtion
 */

@Target({ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationAspect {
	
	String string() default "";
	int intmethod() default 2;
	
}
