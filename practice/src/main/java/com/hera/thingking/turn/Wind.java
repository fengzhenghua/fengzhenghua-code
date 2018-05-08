package com.hera.thingking.turn;


/**
 *@authur fengzhenghua 2017年11月7日 下午11:30:20
 *@ClassName Wind
 *@Describtion
 */
public class Wind extends Instrument{
	
	@Override
	public void play() {
		System.out.println("child play method");
	}
	
	public static void main(String[] args) {
		Wind wind = new Wind();
		Instrument.tune(wind);
		Instrument ins = new Wind();
		ins.play();//父类的引用，调用的是子类方法
	}
}