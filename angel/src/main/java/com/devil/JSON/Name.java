package com.devil.JSON;

public class Name {
	private String xiaoming;
	private String xiaohong;
	public String getXiaoming() {
		return xiaoming;
	}
	public void setXiaoming(String xiaoming) {
		this.xiaoming = xiaoming;
	}
	public String getXiaohong() {
		return xiaohong;
	}
	public void setXiaohong(String xiaohong) {
		this.xiaohong = xiaohong;
	}
	@Override
	public String toString() {
		return "Name [xiaoming=" + xiaoming + ", xiaohong=" + xiaohong + "]";
	}
	
}
