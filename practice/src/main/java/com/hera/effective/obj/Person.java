package com.hera.effective.obj;

import static org.hamcrest.CoreMatchers.instanceOf;

/**
 *@authur fengzhenghua 2017年12月4日 上午1:33:46
 *@ClassName Person
 *@Describtion
 */
public class Person {
	
	private String str;
	private int n;
	private int hashCode;
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(obj == this) return true;
		return obj instanceof Person && ((Person)obj).n==n
				&& ((Person)obj).str.equals(str);
	}
	
	@Override
	public int hashCode() {
		int h = hashCode;
		if(hashCode==0) {
			h = 17;
			h = h*31 + str.hashCode();
			h = h + n;
			return h;
		}
		return h;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
	
	
}
