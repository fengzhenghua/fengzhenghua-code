package com.devil.enum1;

/**
 *@authur fengzhenghua 2017年10月28日 上午12:51:44
 *@ClassName Course
 *@Describtion
 */
public enum Course {
	
	MAINCOURSE(Food.MainSource.class),
	VEGETABLE(Food.Vegetable.class),
	ROU(Food.Rou.class);
	
	private Food[] foods;
	private Course(Class<? extends Food> kind) {
		foods = kind.getEnumConstants();
	}
	
	/**
	 * 随机生成一种食物
	 * @return
	 */
	public  Food randomSelection() {
		return Enums.random(foods);
	}
}
