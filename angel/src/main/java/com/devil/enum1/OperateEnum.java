package com.devil.enum1;

import java.util.EnumSet;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月7日 上午12:09:05
 *@ClassName OperateEnum
 *@Describtion
 */
public class OperateEnum {
	
	@Test
	public void testEnum() {
		
		//System.out.println(EnumColor.BLUE.getColor());
		EnumSet<EnumColor> eset = EnumSet.allOf(EnumColor.class);
		
		for(EnumColor e : eset) {
			
			//System.out.println(e.getColor() + e.getI()[1]);
			System.out.println(e);
		}
		EnumColor e = EnumColor.BLUE;
		for(EnumColor en : e.getClass().getEnumConstants()) {
			System.out.println(en);
		}
	}
	
	@Test
	public void testEnum1() {
		for(EnumColor e : EnumColor.values()) {
			System.out.println(e.name() + " " + e.ordinal() + " " + e.hashCode());
		}
	}
}
