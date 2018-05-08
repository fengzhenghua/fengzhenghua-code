package com.devil.redis;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.devil.seralize.Person;
import com.devil.seralize.SeralizTool;

import redis.clients.jedis.Jedis;

/**
 *@authur fengzhenghua 2017年8月29日 上午1:59:54
 *@ClassName JedisTest
 *@Describtion
 */
public class JedisTest {
	
	private static Jedis jedis;
	static {
		//设置连接
	    jedis = new Jedis("47.94.94.39",5902);
	    jedis.auth("mountain");
	}
	@Test
	public void getRedisData() {
	    //保存数据
	    jedis.set("name","小明");
	    //获取数据
	    String name = jedis.get("name");
	    System.out.println(name);
	    //释放资源
	    jedis.close();
	}
	
	@Test
	public void RedisTest() {
		
		Set<String> sets = jedis.keys("*");
		Iterator<String> it = sets.iterator();
		while(it.hasNext()) {
			String key =  it.next();
			System.out.println(key);
		}
		
	}
	
	@Test
	public void RedisTest1() throws UnsupportedEncodingException {
		Person person = new Person("小华", 18, "男");
		byte[] bytes = SeralizTool.seralize(person);
		String key = "person";
		jedis.hset(key.getBytes("UTF-8"), "attribute".getBytes("UTF-8"), bytes);
		
	}
	/**
	 * 获取person对象
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void getPerson() throws UnsupportedEncodingException {
		
//		String resurt = jedis.hget("person", "attribute");
//		byte[] bytes = resurt.getBytes();
//		Object obj = SeralizTool.byteToObj(bytes);
//		Person person = (Person) obj;
//		System.out.println(person.getAge());
		/**
		 * 可使用hash方法持久化数据库，把数据库设为key,数据表设为field,List<Po>设为value,
		 * 获取到value后，再将其反序列化，将对象存到一个map里面。
		 */
		byte[] by = jedis.hget("person".getBytes("UTF-8"),"attribute".getBytes("UTF-8"));
		Object obj = SeralizTool.byteToObj(by);
		Person person = (Person) obj;
		System.out.println(person.getAge()+person.getName()+person.getSex());
		//System.out.println(by.toString());
	}
}
