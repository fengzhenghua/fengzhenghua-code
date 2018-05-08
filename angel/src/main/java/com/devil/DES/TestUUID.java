package com.devil.DES;

import java.util.UUID;

import org.junit.Test;

public class TestUUID {
	
	@Test
	public void PrintUUID(){
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
	}
}
