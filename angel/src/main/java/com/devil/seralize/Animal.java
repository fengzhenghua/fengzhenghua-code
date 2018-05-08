package com.devil.seralize;

/**
 *@authur fengzhenghua 2017年10月15日 下午11:27:35
 *@ClassName Animal
 *@Describtion
 */
public class Animal {
	
	private String name;
	private float weight;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + ", weight=" + weight + ", type=" + type + "]";
	}
	
	

}
