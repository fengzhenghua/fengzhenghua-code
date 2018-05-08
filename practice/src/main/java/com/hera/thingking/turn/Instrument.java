package com.hera.thingking.turn;

/**
 *@authur fengzhenghua 2017年11月7日 下午11:27:55
 *@ClassName Instrument
 *@Describtion
 */
public class Instrument {
	
	
	public void play() {
		System.out.println("perant play method");
	}
	
	static void tune(Instrument i) {
		i.play();
	}
	
	
}
