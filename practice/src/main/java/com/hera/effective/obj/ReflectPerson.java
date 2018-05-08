package com.hera.effective.obj;

import java.lang.reflect.Field;

/**
 *@authur fengzhenghua 2017年12月5日 上午12:39:27
 *@ClassName ReflectPerson
 *@Describtion
 */
public class ReflectPerson {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Person person = new Person();
		Class<Person> clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f : fields) {
			if(f.getName().equals("str")) {
				f.setAccessible(true);
				f.set(person, "setStr");
			}
			if(f.getName().equals("n")) {
				f.setAccessible(true);
				f.set(person, 12345);
			}
		}
		System.out.println(person.getN());
		System.out.println(person.getStr());
	}
}
