package com.arthur.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

import com.alibaba.fastjson.JSONObject;
import com.arthur.base.Music;
import com.arthur.constants.Constants;
import com.arthur.util.Check;
import com.arthur.util.MusicData;
import com.arthur.util.WeatherData;
import com.arthur.util.XmlUtil;
import com.arthur.vo.TextMessageVo;

/**
 * Servlet implementation class WeChatServlet
 */
public class WeChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Logger logger = Logger.getLogger(WeChatServlet.class);
    
    public WeChatServlet() {
        super();
        
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("=========get执行开始");
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		logger.info("==========get参数----------->"+signature+" ,"+timestamp+" ,"+nonce+" ,"+echostr);
		PrintWriter print = response.getWriter();
		boolean flag = Check.checkSignature(signature, timestamp, nonce);
		logger.info("=========flag--->"+flag);
		if(flag){
			print.print(echostr);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		logger.info("=========post执行开始");
		PrintWriter out = response.getWriter();
		try {
			Map<String,String> dataMap = XmlUtil.xmlToMap(request);
			String ToUserName =  dataMap.get("ToUserName");
			String FromUserName =  dataMap.get("FromUserName");
			//String CreateTime =(String) dataMap.get("CreateTime");
			String MsgType =  dataMap.get("MsgType");
			TextMessageVo vo = new TextMessageVo();
			String message=null;
			//String message1 = null;
			logger.info("=============MsgType:"+MsgType);
			if(Constants.MESSAGE_TEXT.equals(MsgType)){
				
				String Content =  dataMap.get("Content");
				String subWeather = Content.substring(Content.length()-2);
				if("1".equals(Content)){
					logger.info("1=============Content:"+Content);
				    message = XmlUtil.initNews(ToUserName,FromUserName);
				}else if("2".equals(Content)){
					MusicData musicData = new MusicData();
					Map<String,String> map = musicData.getMusicDataMap(Content, "10");
					
					Music music = new Music();
					//music.setDescription(Recognition);
					music.setTitle("for you");
					music.setMusicUrl("http://fs.web.kugou.com/f7143d3e4269cc319135779d09dbaa8b/596bba9e/G006/M09/0F/19/poYBAFS3WB-ACndOAKOXMgd6nAg842.mp3");
					music.setThumbMediaId(map.get("ThumbMediaId"));
					logger.info("============ThumbMediaId==========>"+map.get("ThumbMediaId"));
					music.setDescription(map.get("Description"));
					music.setHQMusicUrl("http://fs.web.kugou.com/f7143d3e4269cc319135779d09dbaa8b/596bba9e/G006/M09/0F/19/poYBAFS3WB-ACndOAKOXMgd6nAg842.mp3");
					
					message = XmlUtil.initMusic(ToUserName, FromUserName, music);
					message = message.replace("music", "Music");
				}else if(subWeather.equals("天气")){
					String city = Content.substring(0,subWeather.length());
					WeatherData weatherData = new WeatherData();
					String WeatherStr = weatherData.WeatherJson(city);
					String WeatherText = weatherData.getWeatherString(WeatherStr);
					message = XmlUtil.initText(ToUserName, FromUserName, WeatherText);
				}
					else{
					//logger.info("====================语音识别:"+Recognition);
					MusicData musicData = new MusicData();
					Map<String,String> map = musicData.getMusicDataMap(Content, "10");
					
					Music music = new Music();
					//music.setDescription(Recognition);
					music.setTitle(map.get("Title"));
					music.setMusicUrl(map.get("MusicURL"));
					music.setThumbMediaId(map.get("ThumbMediaId"));
					logger.info("============ThumbMediaId==========>"+map.get("ThumbMediaId"));
					music.setDescription(map.get("Description"));
					music.setHQMusicUrl(map.get("HQMusicUrl"));
					
					message = XmlUtil.initMusic(ToUserName, FromUserName, music);
					message = message.replace("music", "Music");
				}
				//else if("2".equals(Content)){
//					logger.info("2=============Content:"+Content);
//					message = XmlUtil.initText(ToUserName, FromUserName, XmlUtil.SecondmenuText());
//				}else if("?".equals(Content) || "？".equals(Content)){
//					logger.info("?=============Content:"+Content);
//					message = XmlUtil.initText(ToUserName, FromUserName, "强花虎喂猫猫");
//				}else{
//					logger.info("=============Content:"+Content);
//					String addStr = "亲,你发送的消息是:";
//					message = XmlUtil.initText(ToUserName, FromUserName, addStr+Content);
//				}
			}else if(Constants.MESSAGE_EVENT.equals(MsgType)){
				String eventType = dataMap.get("Event");
				logger.info("=============eventType:"+eventType);
				if(Constants.MESSAGE_SUBSCRIBE.equals(eventType)){
					message = XmlUtil.initText(ToUserName, FromUserName, XmlUtil.menuText());
				}
			}else if(Constants.MESSAGE_VOICE.equals(MsgType)){
				//String MediaId = dataMap.get("MediaId");
				//String Format 
				String Recognition = dataMap.get("Recognition");
				logger.info("====================语音识别:"+Recognition);
//				if("视频".equals(Recognition.substring(Recognition.length()-2))){
//					
//				}
				Recognition = Recognition.substring(0,Recognition.length()-1);
				String subWeather = Recognition.substring(Recognition.length()-2);
				//判断语音识别天气后两位
				if("天气".equals(subWeather)){
					String city = Recognition.substring(0,subWeather.length());
					WeatherData weatherData = new WeatherData();
					String WeatherStr = weatherData.WeatherJson(city);
					String WeatherText = weatherData.getWeatherString(WeatherStr);
					message = XmlUtil.initText(ToUserName, FromUserName, WeatherText);
				}else{
				
					MusicData musicData = new MusicData();
	
					Map<String,String> map = musicData.getMusicDataMap(Recognition, "10");
					
					Music music = new Music();
	
					music.setTitle(map.get("Title"));
					music.setMusicUrl(map.get("MusicURL"));
					music.setThumbMediaId(map.get("ThumbMediaId"));
					logger.info("============ThumbMediaId==========>"+map.get("ThumbMediaId"));
					music.setDescription(map.get("Description"));
					music.setHQMusicUrl(map.get("HQMusicUrl"));
					message = XmlUtil.initMusic(ToUserName, FromUserName, music);
					message = message.replace("music", "Music");
				}
			}
			//logger.info("==========post参数----------->"+vo.toString());
			logger.info("==========message----------->"
			+message);
			out.print(message);
			//out.print(message1);
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
/*		String message =	
		"<xml>"
		+"<ToUserName>gh_69ad81d3c473</ToUserName>"
		+"<FromUserName>oHj9k1XD20pecDdKOeJo3MlErSgU</FromUserName>"
		+"<CreateTime>1498736786113</CreateTime>"
		+"<MsgType>text</MsgType>"
		+"<Content>帅哥or美女你好，你发送的消息是恩哦哦哦</Content>"9-
		+"</xml>";
		out.print(message)*/;
	}

}
