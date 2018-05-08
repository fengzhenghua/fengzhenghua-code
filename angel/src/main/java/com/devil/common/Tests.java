package com.devil.common;

import org.junit.Test;

import com.devil.seralize.Animal;
import com.devil.seralize.Person;

public class Tests {
	
	public static void main(String[] args) {
		TestEnum e = TestEnum.ABC;
		System.out.println(e.getA());
	}
	
	@Test
	public void getIns() {
		
		Singleton singleton = Singleton.getInstance();
		
	}
	
	public void test(StringBuffer sb) {
		
		sb.append("kkkkkkkk");
	}
	
	public void test1(final Animal animal) {
		animal.setName("狗");//不会出错，内存地址未发生改变
		animal.setType("哺乳");
		animal.setWeight(30.0f);
	}
	
	@Test
	public void stringTest() {
//		String arr = " k";
//		test(arr);
//		System.out.println(arr);
		//Person p = new Person("uzi", 20, "man");
		//StringBuffer sb = new StringBuffer("setProperty(");
		//sb.append(p);
		StringBuffer sb = new StringBuffer("my ");
		test(sb);
		System.out.println(sb.toString());
	}
	
	@Test
	public void annimalTest() {
		Animal animal = new Animal();
		test1(animal);//调用test1,改变了所传参数的内容
		System.out.println(animal);
	}
	
	public void addTest(final int n) {
		//n++;//会报错，内存发生改变
	}
}
