package com.devil.time;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年10月6日 下午4:06:42
 *@ClassName TimeTest
 *@Describtion
 */
public class TimeTest {
	
	@Test
	public void testCalender() {
		Calendar cal = Calendar.getInstance();
		cal.set(1994,2,8,16,30,30);
		Date date = cal.getTime();
		Date date1 = new Date();
		System.out.println("出生时间戳" + date.getTime());
		System.out.println("当前时间戳：" + date1.getTime());
		System.out.println("活的时间戳" + (date1.getTime()-date.getTime()));
		Calendar cal1 = Calendar.getInstance();
		cal1.setTimeInMillis(date1.getTime()-date.getTime());
		System.out.println(cal1.get(Calendar.YEAR));
		Calendar cal2 = Calendar.getInstance();
		int nowYear = cal2.get(Calendar.YEAR);
		int lastYear = cal.get(Calendar.YEAR);
		System.out.println(nowYear-lastYear);
	}
}
