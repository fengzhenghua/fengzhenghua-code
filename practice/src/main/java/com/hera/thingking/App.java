package com.hera.thingking;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InstantiationException, IllegalAccessException
    {
       ///// System.out.println( "Hello World!" );
       // assert 1==2:"i love you";
        Map<String,Object> map = App.<String,Object>map();//---------------------此种写法 attention
        map.put("key", "value");
        Class<HashMap<String, Object>> clazz = (Class<HashMap<String, Object>>) new HashMap<String, Object>().getClass();
        Map<String, Object> invokeMap = clazz.newInstance();
        invokeMap.put("key", "value");
        System.out.println(invokeMap.get("key"));
    }
    
    public String test() {
    	System.out.println();
    	return "aa";
    }
    
    public String doSomthing() {
    	return App.this.test();
    }
    
    public static <K,V> Map<K,V> map(){
    	return new HashMap<K,V>();
    }
    
}
