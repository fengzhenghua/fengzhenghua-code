package com.devil.ioc;

public class BanYan {
	
	private GeLi geLi;
	
	public void act(GeLi geLi){
		
		this.geLi = geLi;
	}
	
	public  void actorAct(){
		geLi.acting();
	}
}
