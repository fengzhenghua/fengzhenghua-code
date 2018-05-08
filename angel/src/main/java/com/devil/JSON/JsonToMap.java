package com.devil.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonToMap {

	public static Map Json2map(String jsonStr){
		
		if(jsonStr.startsWith("{")&&jsonStr.endsWith("}")){
			Map<String,Object> map = new HashMap<String,Object>();
			JSONObject jsonObject  = JSONObject.parseObject(jsonStr);
			Set sets = jsonObject.keySet();
			for(Object k : sets){
				Object v = jsonObject.get(k);
				if(v instanceof JSONArray){
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
					Iterator it = ((JSONArray) v).iterator();
					if(it.hasNext()){
						JSONObject json = (JSONObject) it.next();
						list.add(Json2map(json.toJSONString()));
					}
					map.put(k.toString(), list);
				}else{
					map.put(k.toString(), v);
				}
			}
			return map;
		}else{
			return null;
		}
		
	}
}
