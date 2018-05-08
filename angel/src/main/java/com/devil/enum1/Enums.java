package com.devil.enum1;

import java.util.Random;

/**
 *@authur fengzhenghua 2017年10月27日 下午11:25:26
 *@ClassName Enums
 *@Describtion 随机获取一个枚举
 */
public class Enums {
	
	private static Random rand = new Random(47);
	
	public static <T extends Enum<T> > T random(Class<T> ec) {
		return random(ec.getEnumConstants());
	}
	
	public static <T> T random(T[] values) {
		return values[rand.nextInt(values.length)];
	}
}
