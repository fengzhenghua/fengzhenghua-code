package com.devil.num;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Calendar;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月24日 上午1:51:30
 *@ClassName BigInt
 *@Describtion
 */
public class BigInt {
	
	@Test
	public void testBigInteger() {
		BigInteger bi = new BigInteger("333333333333333333333333333333333333333333333333");
		BigInteger bit = bi.add(new BigInteger("1"));
		BigInteger bx = bi.multiply(new BigInteger("3"));
		System.out.println(bit);
		System.out.println(bi.longValue());
		System.out.println(bx);
		
	}
}
