package com.hera.thingking.inner;

/**
 *@authur fengzhenghua 2017年11月6日 上午12:14:17
 *@ClassName DotNew
 *@Describtion
 */
public class DotNew {
	
	public class Inner{void newMethod(){System.out.println(".new");}}
	public static void main(String[] args) {
		DotNew dn = new DotNew();//构造一个外部对象调用内部
		DotNew.Inner di = dn.new Inner();//外部.内部 引用 = 外部对象.new 内部构造器()
		di.newMethod();
	}
	
	public void test() {
		DotNew.Inner di = this.new Inner(); //this.new 
	}
}
