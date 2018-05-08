package com.hera.thingking.builder;

import java.util.HashMap;
import java.util.Map;

/**
 *@authur fengzhenghua 2017年11月25日 上午12:04:47
 *@ClassName Effective
 *@Describtion
 */
public class Effective {
	
	private String name;
	private String money;
	private int age;
	private double high;
	private Map<String, Object> map = new HashMap<String, Object>();
	
	public interface IBuilder<T>{
		public T build();
	}
	
	public static class Builder implements IBuilder<Effective>{
		private String name;
		private String money;
		private int age;
		private double high;
		private Map<String, Object> map = new HashMap<String, Object>();
		public Builder(String name,String money){
			this.name = name;
			this.money = money;
		}
		public Builder() {}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder money(String money) {
			this.money = money;
			return this;
		}
		
		public Builder age(int age) {
			this.age = age;
			return this;
		}
		public Builder high(double high) {
			this.high = high;
			return this;
		}
		public Builder addMap(String key, Object value) {
			this.map.put(key, value);
			return this;
		}
		
		public Effective build() {
			return new Effective(this);
		}
		
		public Effective build(IBuilder<? extends Builder> builder) {
			Builder b = builder.build();
			this.age = b.age;
			this.high = b.high;
			this.map = b.map;
			this.money = b.money;
			this.name = b.name;
			return new Effective(this);
		}
	}
	
	public static Builder newBuilder() {
		return new Builder();
	}
	
	public Effective(Builder builder) {
		name = builder.name;
		money = builder.money;
		age = builder.age;
		high = builder.high;
		this.map = builder.map;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
}
