package com.devil.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

import org.apache.log4j.Logger;

public class InetAddressDemo {
	
	private static Logger logger = Logger.getLogger(InetAddressDemo.class);
	
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress address = InetAddress.getLocalHost();
		logger.info("==============HostAddr:"+address.getHostAddress());
		logger.info("================HostName:"+address.getHostName());
		byte[] addr = address.getAddress();
		logger.info("==============addrStr:"+Arrays.toString(addr));
		System.out.println(address);
		InetAddress address1 = InetAddress.getByName("47.94.94.39");
		System.out.println(address1);
	}
}
