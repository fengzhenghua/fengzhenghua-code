package com.devil.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 *@authur fengzhenghua 2017年11月9日 上午1:10:57
 *@ClassName AutomicReferenceTest
 *@Describtion
 */
public class AutomicReferenceTest {
	
	public static AtomicReference<User> atomicUerReference = new AtomicReference<User>();
	
	public static void main(String[] args) {
		User user = new User("kangkang", 18);
		atomicUerReference.set(user);
		User updateUser = new User("jene", 19);
		atomicUerReference.set(updateUser);
		System.out.println(atomicUerReference.get().getName());
		System.out.println(atomicUerReference.get().getOld());
	}
	
	static class User{
		
		public User(String name, int old) {
			this.name = name;
			this.old = old;
		}
		private String name;
		private int old;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getOld() {
			return old;
		}
		public void setOld(int old) {
			this.old = old;
		}
		
		
	}
}
