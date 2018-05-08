package com.devil.enum1;

/**
 *@authur fengzhenghua 2017年10月28日 上午12:46:39
 *@ClassName Food
 *@Describtion
 */
public interface Food {
	
	enum MainSource implements Food{
		SOURCE1, SOURCE2, SOURCE3 ,SOURCE4;
	}
	
	enum Vegetable implements Food{
		SOURCE5, SOURCE6, SOURCE7 ,SOURCE8;
	}
	
	enum Rou implements Food{
		SOURCE9, SOURCE10, SOURCE11 ,SOURCE12;
	}
}
