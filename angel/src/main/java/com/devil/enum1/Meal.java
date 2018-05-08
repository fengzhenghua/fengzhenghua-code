package com.devil.enum1;

/**
 *@authur fengzhenghua 2017年10月28日 上午1:03:39
 *@ClassName Meal
 *@Describtion
 */
public class Meal {
	
	public static void main(String[] args) {
		for(int i=0;i<5;i++) {
			Course[] c = Course.values();
			for(Course co : c) {
				Food food = co.randomSelection();
				System.out.println(food);
			}
			System.out.println("-----");
		}
	}
}
