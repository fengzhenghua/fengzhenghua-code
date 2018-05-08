package com.devil.ioc;

public class Director {
	
	public static void main(String[] args) {
		BanYan banYan = new BanYan();
		GeLi geLi = new LiuDeHua();
		banYan.act(geLi);
		banYan.actorAct();
	}
	
}
