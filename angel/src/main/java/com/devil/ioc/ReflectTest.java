package com.devil.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
	
	public static Car intByDefaultConsts() throws Throwable{
		
		//1.通过类装载器获取car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("com.devil.ioc.Car");
		
		//2.获取类的默认构造器对象并通过他实例化Car
		Constructor cons = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car) cons.newInstance();
		
		//3.通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "红旗CA72");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "蓝色");
		Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
		setMaxSpeed.invoke(car, 300);
		return car;
	}
	
	public static void main(String[] args) throws Throwable {
		Car car = intByDefaultConsts();
		car.introduce();
	}
}
