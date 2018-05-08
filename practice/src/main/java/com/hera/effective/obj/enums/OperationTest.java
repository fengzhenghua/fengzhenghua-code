package com.hera.effective.obj.enums;

import java.util.Arrays;
import java.util.Collection;

/**
 *@authur fengzhenghua 2018年1月7日 上午1:11:58
 *@ClassName OperationTest
 *@Describtion
 */
public class OperationTest {
	
	public static void main(String[] args) {
		//int k = Operation.DEL.oper(1, 2);
		//System.out.println(k);
		//System.out.println(args.toString());
		for(String s :args) {
			System.out.println("==="+s);
		}
		double x = Double.parseDouble("1.5");
		double y = Double.parseDouble("1.0");
		test(BasicOperation.class, x, y);
		test(Arrays.asList(BasicOperation.values()),x ,y);
		Integer in = testInstanceOf(Integer.class);
		String ss = testInstanceOf(String.class);
		System.out.println(in);
		System.out.println(ss);
		System.out.println(String.class.isInstance("2"));
	}
	
	private static <T extends Enum<T> & IOperation> void test(Class<T> opSet, double x, double y) {
		for(IOperation op : opSet.getEnumConstants()) {
			System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
		}
	}
	
	private static void test(Collection<? extends IOperation> opSet, 
			double x, double y) {
		for(IOperation op : opSet) {
			System.out.printf("%f %s %f = %f%n",x, op, y, op.apply(x, y));
		}
	}
	
	private static <T> T testInstanceOf(Class<T> obj){
		if(obj == Integer.class) {
			T t = (T) new Integer(2);
			return t;
		}else if(obj.isInstance("kkk")) {
			T t = (T) new String("123");
			return t;
		}
		return null;
	}
}	
