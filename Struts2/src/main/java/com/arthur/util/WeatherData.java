package com.arthur.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;



import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class WeatherData {
	
	private Logger logger = Logger.getLogger(WeatherData.class);
	/*
	 * 返回天气数据
	 */
	public String WeatherJson(String city) throws Exception{
		//参数url化
		//String city = java.net.URLEncoder.encode("北京", "utf-8");
		
		//拼地址
		String apiUrl = String.format("http://www.sojson.com/open/api/weather/json.shtml?city=%s",city);
		//开始请求
		URL url= new URL(apiUrl);
		URLConnection open = url.openConnection();
		InputStream input = open.getInputStream();
		//这里转换为String，带上包名，怕你们引错包
		//String result = org.apache.commons.io.IOUtils.toString(input,"utf-8");
		//输出
		BufferedReader br = new BufferedReader(new InputStreamReader(input));
		String data = null;
		String string = "";
		while((data=br.readLine())!=null) {
			string += data;
		}
		return string;
	}
	
	@Test
	public void getW() throws Exception {
		String resurt = WeatherJson("重庆");
		//System.out.println(resurt);
		JSONObject node = JSON.parseObject(resurt);
		JSONObject data = node.getJSONObject("data");
		JSONArray jsonArray = data.getJSONArray("forecast");
		System.out.println(jsonArray);
		//JSONObject json = jsonArray.getJSONObject(0);
		//System.out.println(data.toJSONString());
	}
	/*
	 * 获取天气中json数据
	 */
	public String getWeatherString(String resurlt){
		
		JSONObject json = JSON.parseObject(resurlt);
		String city = json.getString("city");
		String data = json.getString("data");
		//data节点下json对象
		JSONObject json1 = JSON.parseObject(data);
		//String city = json1.getString("city");
		String wendu = json1.getString("wendu");
		//温馨提示
		String ganmao = json1.getString("ganmao");
		StringBuilder sb = new StringBuilder();
		sb.append("你好！华哥哥为你服务，"+city+"天气⇓⇓\n");
		sb.append("当前温度："+wendu+"℃").append("\n");
		String jsonForecast = json1.getString("forecast");
		logger.info("=================jsonForecast:"+jsonForecast);
		JSONArray forecast = JSONArray.parseArray(jsonForecast);
		for(int i=0;i<3;i++){
			String day = "";
			if(i == 0){
				day = "今天";
			}else if(i == 1){
				day = "明天";
			}else{
				day = "后天";
			}
			JSONObject weatherJson = forecast.getJSONObject(i);
			String date = weatherJson.getString("date");
			String high = weatherJson.getString("high");
			String low = weatherJson.getString("low");
			String type = weatherJson.getString("type");
			sb.append(day).append(date+",").append(type+",").append("最"+high+",").append("最"+low).append("。").append("\n");	
		}
		sb.append("温馨提示："+ganmao);
		return sb.toString();
	}
}
