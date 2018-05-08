package com.devil.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class TestCast {
	private static Logger logger = Logger.getLogger(TestCast.class);
	
	public static void main(String[] args) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		json1.put("关羽", "张飞");
		json.put("魏国", "曹操");
		json.put("吴国", "孙权");
		json.put("蜀国", "刘备");
		json.put("三国", json1);
//		json1.put("魏国", "司马懿");
//		json1.put("吴国", "周瑜");
//		json1.put("蜀国", "诸葛亮");
		jsonArr.add(json);
//		jsonArr.add(json1);
		Map map = JsonToMap.Json2map(json.toJSONString());
//		Map mapArr = JsonToMap.Json2map(jsonArr.toJSONString());
		logger.info(map.toString());
		logger.info(map.get("三国"));
//		logger.info(jsonArr.toJSONString());
		//logger.info(mapArr.toString());
	}
	@Test
	public void JsonToBean() throws IllegalAccessException, InvocationTargetException{
		String jsonStr = "{\"xiaoming\":\"23\",\"xiaohong\":\"22\"}";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("xiaoming", "22");
		map.put("xiaohong", "44");
		JSONObject jsonObject = new JSONObject().parseObject(jsonStr);
		Name name = (Name)JSONObject.toJavaObject(jsonObject, Name.class);
		Name name1 = new Name();
		System.out.println(name.toString());
		//BeanUtils.copyProperties(name1,map);//spring包转化不了map
		org.apache.commons.beanutils.BeanUtils.populate(name1, map);
		System.out.println(name1.toString());
	}
	
	@Test
	public void tobean() {
		String jsonStr = "{\"xiaoming\":\"23\",\"xiaohong\":\"22\"}";
	}
}
