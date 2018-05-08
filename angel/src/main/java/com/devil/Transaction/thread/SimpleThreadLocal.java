package com.devil.Transaction.thread;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SimpleThreadLocal {
	
	private Map valueMap = Collections.synchronizedMap(new HashMap());
	
	public void set(Object newValue){
		valueMap.put(Thread.currentThread(), newValue);
	}
	
	public Object get(){
		Thread currentThread = Thread.currentThread();
		Object o = valueMap.get(currentThread);
		if(o == null && !valueMap.containsKey(currentThread)){
			o = initiaValue();
			valueMap.put(currentThread, 0);
		}
		return o;
	}
	
	public void remove(){
		valueMap.remove(Thread.currentThread());
	}
	
	public Object initiaValue(){
		return null;
	}
}
