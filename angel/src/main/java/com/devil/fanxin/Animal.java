package com.devil.fanxin;

/**
 *@authur fengzhenghua 2017年10月29日 上午1:40:06
 *@ClassName Animal
 *@Describtion
 */
public class Animal<T> {
	
	T a;
	
	public void get() {
		System.out.println(a.toString());
	}
	
	public Animal(T a) {
		this.a = a;
	}
	
	public  Animal<T> method(T n){
		return new Animal<T>(n);
	}
	
	public static void main(String[] args) {
		Animal<Integer> ani = new Animal<Integer>(2);
		ani.get();
	}
	//public 
}
