package com.hera.effective.obj;

/**
 *@authur fengzhenghua 2018年1月3日 上午1:32:20
 *@ClassName Stratety
 *@Describtion
 */
public interface Stratety<T> {
	
	int compare(T t1, T t2);
	
	@SuppressWarnings("unchecked")
	void merge(T... ts);
}
