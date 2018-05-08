package com.devil.enum1;

/**
 *@authur fengzhenghua 2017年9月7日 上午12:04:50
 *@ClassName EnumColor
 *@Describtion
 */
public enum EnumColor {
	
	RED("红",new int[] {1,2,3}),BLUE("蓝",new int[] {4,5,6}),YELLOW("黄",new int[] {7,8,9});
	
	private String color;
	private int[] i;

	private EnumColor(String color,int[] i) {
		this.color = color;
		this.i = i;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int[] getI() {
		return i;
	}

	public void setI(int[] i) {
		this.i = i;
	}
	
	@Override
	public String toString() {
		return color + "-->" + i[0] + i[1] + i[2];
	}
	
}
