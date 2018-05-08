package com.hera.effective.obj;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *@authur fengzhenghua 2018年1月3日 上午1:33:09
 *@ClassName StratetyImpl
 *@Describtion
 */
public class StratetyImpl<E> implements Stratety<String> {
	
	Class<E> clazz;
	
	@Override
	public int compare(String t1, String t2) {
		return t1.length() - t2.length();
	}

	@Override
	public void merge(String... t) {
		StringBuilder sb = new StringBuilder();
		for(String s : t) {
			sb.append(s);
		}
		
	}
	
	public  E newInstance() throws InstantiationException, IllegalAccessException {
		clazz = (Class<E>) this.getClass();
		return clazz.newInstance();
	}
	
	public StratetyImpl() {
		Class<?> cla = this.getClass();
		ParameterizedType type = (ParameterizedType) cla.getGenericSuperclass();
		System.out.println(type);
		Type[] types = type.getActualTypeArguments();
        
		clazz = (Class<E>) types[0];
        System.out.println(clazz.getSimpleName());
	}
	
}
