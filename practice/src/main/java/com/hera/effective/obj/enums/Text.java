package com.hera.effective.obj.enums;

import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

/**
 *@authur fengzhenghua 2018年1月7日 上午1:38:28
 *@ClassName Text
 *@Describtion
 */
public class Text {
	
	enum Styles{BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}
	
	public void applyStyles(Set<Styles> styles) {
		
		for(Styles s : styles) {
			System.out.println(s.name());
		}
		
	}
	
	@Test
	public void test() {
		Text t = new Text();
		t.applyStyles(EnumSet.of(Styles.BOLD, Styles.UNDERLINE));
		t.applyStyles(EnumSet.allOf(Styles.class));
	}
}
