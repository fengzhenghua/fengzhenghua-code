package com.hera.aspectj;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hera.effective.obj.Person;

/**
 *@authur fengzhenghua 2017年12月4日 下午9:12:48
 *@ClassName CallDemo
 *@Describtion
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CallDemo {
	//@Resource
	PointDemo cDemo;
	
	@Before
	public void before() {
		ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
		cDemo = act.getBean(PointDemo.class);
	}

	
	@Test
	public void call() {
		//PointDemo cDemo = new PointDemo();
		Person person = new Person();
		person.setN(2);
		person.setStr("point");
		cDemo.point(person, 2, "arg");
	}
	
}
