package com.devil.in;

/**
 *@authur fengzhenghua 2017年10月31日 上午1:00:41
 *@ClassName INetPlayer
 *@Describtion
 */
public interface INetPlayer {
	
	void sendMessage(String message);
	void receiveMessage(String message);
}
