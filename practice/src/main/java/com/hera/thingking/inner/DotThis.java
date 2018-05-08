package com.hera.thingking.inner;

/**
 *@authur fengzhenghua 2017年11月5日 下午11:54:03
 *@ClassName DotThis
 *@Describtion
 */
public class DotThis {
	void f() {System.out.println("DotThis.f()");}
	public class Inner {
		public DotThis outer() {
			return DotThis.this;//返回一个外部类对象，用来调用f()
		}
		public String getString() {
			return "Inner String";
		}
	}
	public Inner inner() {
		return new Inner();
	}
	
	
	public static Inner newBuilder() {
		return new DotThis().inner();
	}
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
		DotThis.Inner d = DotThis.newBuilder();
		System.out.println(d.getString());;
	}
}
