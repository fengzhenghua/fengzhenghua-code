package com.arthur.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.arthur.base.BaseMessagePo;
import com.arthur.base.Music;
import com.arthur.base.News;
import com.arthur.constants.Constants;
import com.arthur.po.MusicMessagePo;
import com.arthur.po.NewsMessagePo;
import com.arthur.po.TextMessagePo;
import com.thoughtworks.xstream.XStream;

public class XmlUtil {
	
	private static Logger logger = Logger.getLogger(XmlUtil.class);
	
	public static Map<String,String> xmlToMap(HttpServletRequest requset) throws IOException, DocumentException{
		
		Map<String,String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		InputStream in = requset.getInputStream();
		//获取文档节点
		Document doc = reader.read(in);
		Element root = doc.getRootElement();
		List<Element> list =root.elements();
		
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		in.close();
		return map;
	}
	
	public static String poToXml(BaseMessagePo po){
		XStream xstream = new XStream();
		xstream.alias("xml", po.getClass());
		String xmlStr = xstream.toXML(po);
		return xmlStr;
	}
	
	public static String poToXml(NewsMessagePo po){
		XStream xstream = new XStream();
		xstream.alias("xml", po.getClass());
		xstream.alias("item", News.class);
		String xmlStr = xstream.toXML(po);
		return xmlStr;
	}
	/**
	 * ��װ�ı���Ϣ
	 * @param toUserName
	 * @param fromUserName
	 * @param content
	 * @return
	 */
	public static String initText(String toUserName,String fromUserName,String content){
		TextMessagePo text = new TextMessagePo();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(Constants.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return poToXml(text);
	}

	public static String menuText(){
		StringBuilder sb = new StringBuilder();
		sb.append("欢迎您的关注。\n");
		sb.append("您可以输入你想听的\"歌曲名字\"或\"歌手\"或\"歌手+歌手名\"或输入歌词进行点歌，语音点歌更方便呢！\n");
		sb.append("输入\"城市名\"+\"天气\"或者语音\"城市名\"+\"天气\"可以查看天气哟！\n");
		sb.append("您的支持是我最大的动力，请多多关注！\n");
		return sb.toString();
	}
	
	public static String FirstmenuText(String toUserName,String fromUserName,String content){
		StringBuilder sb = new StringBuilder();
		sb.append("你好美女or帅哥！");
		return sb.toString();
	}
	
	public static String SecondmenuText(){
		StringBuilder sb = new StringBuilder();
		sb.append("你今天肯定非常的顺心，哈哈哈");
		return sb.toString();
	}
	
	/*
	 * 组装图文消息xml字符串
	 */
	public static String initNews(String toUserName,String fromUserName){
		logger.info("============图文消息开始拼装=============");
		NewsMessagePo newsMessagePo = new NewsMessagePo();
		newsMessagePo.setFromUserName(toUserName);
		newsMessagePo.setToUserName(fromUserName);
		newsMessagePo.setCreateTime(new Date().getTime());
		List<News> Articles = new ArrayList<News>();
		News news = new News();
		news.setPicUrl("http://47.94.94.39/Struts2/images/xingxing1.jpg");
		//news.setUrl("http://fs.web.kugou.com/f7143d3e4269cc319135779d09dbaa8b/596bba9e/G006/M09/0F/19/poYBAFS3WB-ACndOAKOXMgd6nAg842.mp3");
		//news.setUrl("http://www.dd01.com/birthday/2/?n=%u534E%u54E5%u54E5&m=%u661F%u59B9%u59B9");
		news.setUrl("http://www.8zhufu.net/shengri.htm?xname=_u661F_u59B9_u59B9");
		news.setDescription("在你生日这一刻，没能在你身边，对不起!愿我的祝福，如一缕灿烂的阳光，在你的眼里流淌，生日快乐! -->点一哈图片，嘿嘿!<-- \n我还为你准备了一样礼物呢，快看看这个快递单号：236228626194(顺丰)，是我的一番心意喔");
		news.setTitle("给小星星");
		Articles.add(news);
		newsMessagePo.setArticleCount(Articles.size());
		newsMessagePo.setArticles(Articles);
		newsMessagePo.setMsgType("news");
		String newsXmlStr = poToXml(newsMessagePo);
		return newsXmlStr;
		
	}
	//组装音乐信息xml字符串
	public static String initMusic(String toUserName,String fromUserName,Music music){
		logger.info("============音乐消息开始拼装=============");
		MusicMessagePo musicMessagePo = new MusicMessagePo();
		musicMessagePo.setFromUserName(toUserName);
		musicMessagePo.setToUserName(fromUserName);
		musicMessagePo.setMsgType(Constants.MESSAGE_MUSIC);
		musicMessagePo.setCreateTime(new Date().getTime());
		musicMessagePo.setMusic(music);
		String MusicXmlStr = poToXml(musicMessagePo);
		return MusicXmlStr;
	}
	//从语音调用接口获取音乐信息
//	public static Music getMusic(String Recognition){
//		
//	}
}
