package com.arthur.util;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class MusicData {
	
	private static Logger logger = Logger.getLogger(MusicData.class);
	//get搜索请求地址
	private String url = "http://songsearch.kugou.com/song_search_v2?keyword=KEYWORD&page=PAGE&pagesize=PAGESIZE&platform=WebFilter&tag=em";
	//酷狗音乐地址
	private  String musicUrl = "http://www.kugou.com/yy/index.php?r=play/getdata&hash=HASH";
	//上传至微信服务器地址
	private static final String UPLOAD_URL = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"; 
	
	private static final String AppID = "wx81d689d1bbb89f72";
	
	private static final String AppSecret = "795b5a761db3d47ce37f8fbb2b482ed2";
	
	private static String Access_token = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	/*
	 * 返回音乐搜索结果
	 */
	public JSONObject getMusicJsonData(String Recognition,String page_size){
		logger.info("============getMusicJsonData==============>执行开始");
		String keyword = null;
		try {
			keyword = URLEncoder.encode(Recognition, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = url.replace("KEYWORD", keyword).replace("PAGESIZE", page_size);
		JSONObject  jsonObject = HttpClentUtils.getJSONObject(url);
		logger.info("===================="+jsonObject.toJSONString());
		return jsonObject;
	}
	
	/*
	 * 处理搜索音乐返回数据结果,取得hash
	 */
	public  String getJsonDataHash(String Recognition,String page_size){
		
		JSONObject jsonObject = getMusicJsonData(Recognition,page_size);
		
		logger.info("============getJsonDataHash==============>执行开始");
		//data节点
		JSONObject data = (JSONObject) jsonObject.get("data");
		logger.info("================data=======>"+data);
		//data节点下lists节点字符串
		String lists =  data.getString("lists");
		logger.info("==========lists============>"+lists);
		//lists节点下jsonArray字符串
		JSONArray array = JSON.parseArray(lists);
		logger.info("=============lists->array===================>"+array.toJSONString());
		//JSONArray lists = data.getJSONArray("lists");
		//JSONObject jsonInfo = lists.getJSONObject(0);
		Object FileHash = null;
		String fileHashStr = "";
//		for(int i=0;i<array.size();i++){
		JSONObject jsonInfo = array.getJSONObject(0);
		logger.info("==================jsonInfo===================>"+jsonInfo);
		FileHash = jsonInfo.get("FileHash");
		logger.info("FileHash:"+FileHash);
//			map.put(key, value)
		if(FileHash==null || "".equals(FileHash)){
			jsonInfo = array.getJSONObject(1);
			FileHash = jsonInfo.get("FileHash");
			fileHashStr = (String) FileHash;
		}else{
			fileHashStr = (String) FileHash;
		}
		logger.info("==============fileHashStr=============>"+fileHashStr);
		return fileHashStr;
	}
	
	/*
	 * 由以上hash码取得音乐地址，获取返回音乐信息
	 */
	
	public  Map<String,String> getMusicDataMap(String Recognition,String page_size){
		
		String fileHashStr = getJsonDataHash(Recognition,page_size);
		
		//logger.info("============getMusicDataMap================>执行开始,入参:>"+fileHashStr);
		Map<String,String> map = new HashMap<String,String>();
		//拼装音乐url
		musicUrl = musicUrl.replace("HASH", fileHashStr);
		JSONObject  musicJsonObject = HttpClentUtils.getJSONObject(musicUrl);
		String data = musicJsonObject.getString("data");
		logger.info("data===========>"+data);
		JSONObject detail = JSON.parseObject(data);
		//String imageUrl = detail.getString("img");
		String thumbUrl = "/home/tomcat/huahua.jpg";
		String mp3Url = detail.getString("play_url");
		//String title = detail.getString("audio_name").trim();
		String author_name = detail.getString("author_name");
		String song_name = detail.getString("song_name");
		String title = author_name + "-" + song_name;
		String Description = "次音乐来自酷狗，链接由华哥哥抓取";
		map.put("Title", title);
		map.put("Description", Description);
		map.put("MusicURL", mp3Url);
		map.put("HQMusicUrl", mp3Url);
		try {
			//map.put("ThumbMediaId", upload(thumbUrl,getToken(),"thumb"));
			map.put("ThumbMediaId", "qGn-sEROBk-An4EY2DU50LDKeVj2dLIX4yIWktNxdWBzn2FZjRPIH1H-w4h__w03");
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	/*
	 * 文件上传 返回mediaId
	 */
	public static String upload(String imageUrl , String accessToken,String type) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
		logger.info("=============上传文件===============>执行开始");
		File file = new File(imageUrl);
//		URI imgUri = null;
//		try {
//			imgUri = new URI(imageUrl);
//		} catch (URISyntaxException e1) {
//			logger.info("=========URI获取失败=========");
//			e1.printStackTrace();
//			return null;
//			
//		}
		//URL imgUr = new URL(imageUrl);
		//InputStream fileIn = imgUr.openStream();
		if (!file.exists() || !file.isFile()) {
			throw new IOException("文件不存在");
		}
//		BufferedImage bi = ImageIO.read(fileIn);
//		double width = bi.getWidth();
//		double height = bi.getHeight();
//		//double percent = width / height;
//		int newWidth = (int) width*1/3;
//		int newHeight = (int) height *1/3;
//		BufferedImage image = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_BGR);
		
		//获取文件名
		//int index = imageUrl.lastIndexOf("/");
		//String fileName = imageUrl.substring(index);
		String url = UPLOAD_URL.replace("ACCESS_TOKEN", accessToken).replace("TYPE",type);
		logger.info("uploadUrl============>"+url);
		URL urlObj = new URL(url);
		//连接
		HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
		
		con.setRequestMethod("POST"); 
		con.setDoInput(true);
		con.setDoOutput(true);
		con.setUseCaches(false); 

		//设置请求头信息
		con.setRequestProperty("Connection", "Keep-Alive");
		con.setRequestProperty("Charset", "UTF-8");

		//设置边界
		String BOUNDARY = "----------" + System.currentTimeMillis();
		con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

		StringBuilder sb = new StringBuilder();
		sb.append("--");
		sb.append(BOUNDARY);
		sb.append("\r\n");
		sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + file.getName() + "\"\r\n");
		sb.append("Content-Type:application/octet-stream\r\n\r\n");
		logger.info("==================FileName==========>"+file.getName());
		byte[] head = sb.toString().getBytes("utf-8");

		//获得输出流
		OutputStream out = new DataOutputStream(con.getOutputStream());
		//输出表头
		out.write(head);
		
		//文件正文部分
		//把文件已流文件的方式 推入到url中
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		//DataInputStream in = new DataInputStream(fileIn);
		int bytes = 0;
		byte[] bufferOut = new byte[1024];
		while ((bytes = in.read(bufferOut)) != -1) {
			out.write(bufferOut, 0, bytes);
		}
		in.close();

		//结尾部分
		byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");//定义最后数据分隔线

		out.write(foot);

		out.flush();
		out.close();

		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		String result = null;
		try {
			//定义BufferedReader输入流来读取URL的响应
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			if (result == null) {
				result = buffer.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		JSONObject jsonObj = JSON.parseObject(result);
		System.out.println(jsonObj);
		String typeName = "media_id";
		if(!"image".equals(type)){
			typeName = type + "_media_id";
		}
		String mediaId = jsonObj.getString(typeName);
		logger.info("=============mediaId:"+mediaId);
		return mediaId;
	}
	/*
	 * 获取token
	 */
	public  String getToken(){
		Access_token = Access_token.replace("APPID", AppID).replace("APPSECRET", AppSecret);
		logger.info("Access_token  url=============>"+Access_token);
		JSONObject json = HttpClentUtils.getJSONObject(Access_token);
		logger.info("Access_token_JSON:"+json);
		String token = json.getString("access_token");
		logger.info("==============token:"+token);
		
		return token;
	}
	
	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
		MusicData mu = new MusicData();
//		String path = "C:\\Users\\fzh\\Desktop\\huahua.jpg";
//		String mediaId = upload(path,mu.getToken(),"thumb");
		String tk = mu.getToken();
		System.out.println("token:"+tk);
	}
}
