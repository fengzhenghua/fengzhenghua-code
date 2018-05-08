package com.devil.fanxin;

/**
 *@authur fengzhenghua 2018年3月3日 下午11:13:50
 *@ClassName InstanceOf
 *@Describtion
 */
public class InstanceOf<T> {
	
	Class<T> clazz;
	
	public InstanceOf(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public boolean isInstance(Object obj) {
		return clazz.isInstance(obj);
	}
	
	public static void main(String[] args) {
		InstanceOf<Building> iso1 = new InstanceOf<Building>(Building.class);
		System.out.println(iso1.isInstance(new Building()));
		System.out.println(iso1.isInstance(new House()));
		InstanceOf<House> iso2 = new InstanceOf<House>(House.class);
		System.out.println(iso2.isInstance(new Building()));
		System.out.println(iso2.isInstance(new House()));
	}
	
}
class Building{}

class House extends Building{}
