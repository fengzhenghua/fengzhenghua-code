package com.devil.enum1;

import java.util.concurrent.TimeUnit;

/**
 *@authur fengzhenghua 2017年10月27日 下午11:38:57
 *@ClassName RandomTest
 *@Describtion
 */

enum Activity{
	RUNNING, DODGING, JUMPING, FALLING, STANDING, HOPPING, SITTING, LYING, FLYING
}
public class RandomTest {
	
	public static void main(String[] args) {
		for(int i=0;i<20;i++) {
			Enum e = Enums.random(Activity.class);
			System.out.print(e.name() + " ");
		}
	}
	
}
