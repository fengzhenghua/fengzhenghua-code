package com.hera.thingking.inner;

/**
 *@authur fengzhenghua 2017年11月6日 上午12:23:12
 *@ClassName Parcel
 *@Describtion 静态内部类中不需先创建外部对象
 */
public class Parcel {
	
	class Contents{
		private int i = 11;
		public int value() {return i;}
		
	}
	class Destination{
		private String label;
		public Destination(String whereTo) {
			label = whereTo;
		}
		String readLabel() {
			return label;
		}
	}
	
	public static void main(String[] args) {
		Parcel p = new Parcel();
		Parcel.Destination pd = p.new Destination("sure");
		Parcel.Contents pc = p.new Contents();
		System.out.println(pd.readLabel());
		System.out.println(pc.value());
		
	}
}
