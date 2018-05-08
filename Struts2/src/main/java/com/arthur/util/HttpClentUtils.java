package com.arthur.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpClentUtils {
	
	private static RequestConfig requestConfig = RequestConfig.custom()  
		        .setSocketTimeout(15000)  
		        .setConnectTimeout(15000)  
		        .setConnectionRequestTimeout(15000)  
		        .build();  
		      
//    private static HttpClentUtils instance = null;    
    private HttpClentUtils(){}    
//    public static HttpClentUtils getInstance(){    
//        if (instance == null) {    
//            instance = new HttpClentUtils();    
//        }    
//        return instance;  
//    }  
    
    /*
     * get 返回json
     */
	public static JSONObject getJSONObject(String httpUrl){
		
		HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求    
		String responseContent = sendHttpGet(httpGet);
		JSONObject jsonObject = JSONObject.parseObject(responseContent);
		return jsonObject;
	}
	/*
	 * post 返回json
	 */
	public static JSONObject postJsonObject(String httpUrl){
		
		HttpPost httpPost = new HttpPost(httpUrl);
		String responseContent = sendHttpPost(httpPost);
		JSONObject jsonObject = JSONObject.parseObject(responseContent);
		return jsonObject;
		 
	}
	
	/**
	 * get url返回数据
	 * @param httpGet
	 * @return String
	 */
	private static String sendHttpGet(HttpGet httpGet) {    
        CloseableHttpClient httpClient = null;    
        CloseableHttpResponse response = null;    
        HttpEntity entity = null;    
        String responseContent = null;    
        try {    
            // 创建默认的httpClient实例.    
            httpClient = HttpClients.createDefault();    
            httpGet.setConfig(requestConfig);    
            // 执行请求    
            response = httpClient.execute(httpGet);    
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                // 关闭连接,释放资源    
                if (response != null) {    
                    response.close();    
                }    
                if (httpClient != null) {    
                    httpClient.close();    
                }    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
        return responseContent;    
    }  
	
	/**  
     * 发送Post请求  
     * @param httpPost  
     * @return  
     */    
    private static String sendHttpPost(HttpPost httpPost) {    
        CloseableHttpClient httpClient = null;    
        CloseableHttpResponse response = null;    
        HttpEntity entity = null;    
        String responseContent = null;    
        try {    
            // 创建默认的httpClient实例.    
            httpClient = HttpClients.createDefault();    
            httpPost.setConfig(requestConfig);    
            // 执行请求    
            response = httpClient.execute(httpPost);    
            entity = response.getEntity();    
            responseContent = EntityUtils.toString(entity, "UTF-8");    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                // 关闭连接,释放资源    
                if (response != null) {    
                    response.close();    
                }    
                if (httpClient != null) {    
                    httpClient.close();    
                }    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
        return responseContent;    
    }    
    
    private static InputStream sendHttpInputStreamGet(HttpGet httpGet) {    
        CloseableHttpClient httpClient = null;    
        CloseableHttpResponse response = null;    
        HttpEntity entity = null;    
       // String responseContent = null;  
        InputStream in = null;
        try {    
            // 创建默认的httpClient实例.    
            httpClient = HttpClients.createDefault();    
            httpGet.setConfig(requestConfig);    
            // 执行请求    
            response = httpClient.execute(httpGet);    
            entity = response.getEntity();
            //获取文件流
             in = entity.getContent();
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                // 关闭连接,释放资源    
                if (response != null) {    
                    response.close();    
                }    
                if (httpClient != null) {    
                    httpClient.close();    
                }    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        }    
        return in;    
    }
	/**  
     * 发送 post请求  
     * @param httpUrl 地址  
     * @param params 参数(格式:key1=value1&key2=value2)  
     */    
    public String sendHttpPost(String httpUrl, String params) {    
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost      
        try {    
            //设置参数    
            StringEntity stringEntity = new StringEntity(params, "UTF-8");    
            stringEntity.setContentType("application/x-www-form-urlencoded");    
            httpPost.setEntity(stringEntity);    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        return sendHttpPost(httpPost);    
    }    
        
    /**  
     * 发送 post请求  
     * @param httpUrl 地址  
     * @param maps 参数  
     */    
    public String sendHttpPost(String httpUrl, Map<String, String> maps) {    
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost      
        // 创建参数队列      
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();    
        for (String key : maps.keySet()) {    
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));    
        }    
        try {    
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));    
        } catch (Exception e) {    
            e.printStackTrace();    
        }    
        return sendHttpPost(httpPost);    
    }    
	
//	public static void main(String[] args) {
//		 Access_token = Access_token.replace("APPID", AppID).replace("APPSECRET", AppSecret);
//    	JSONObject json = getJSONObject(Access_token);
//    	System.out.println(json.toJSONString());
//	}
}
