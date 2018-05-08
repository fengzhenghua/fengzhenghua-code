package com.devil.in;

import java.util.HashMap;
import java.util.Map;

/**
 *@authur fengzhenghua 2017年10月31日 上午12:59:06
 *@ClassName WorldServer
 *@Describtion
 */
public class WorldServer {
	
	private static  Map<Long,INetPlayer> onlinePlayer = new HashMap<Long, INetPlayer>();
	
	public static  INetPlayer getPlayer(long sessionId) {
		INetPlayer player = onlinePlayer.get(sessionId);
		return player;
	}
	
	public static void main(String[] args) {
		INetPlayer player = WorldServer.getPlayer(22);
	}
}
