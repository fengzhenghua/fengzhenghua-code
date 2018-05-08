package com.devil.xml;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.devil.seralize.Person;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *@authur fengzhenghua 2017年8月27日 下午5:28:42
 *@ClassName XmlReader
 *@Describtion 用4种方法解析xml文件
 */
public class XmlReader {

	/**
	 * Dom方式
	 */
	@Test
	public void domReader() {
		//获取文档工厂对象
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		InputStream is = null;
		try {
			//spring方式获取classpath资源
			Resource res = new ClassPathResource("addr.xml");
			//得到资源输入流
			 is = res.getInputStream();
			//File file = new File("")
			//获取文档建立对象
			DocumentBuilder builder = factory.newDocumentBuilder();
			//获取文档对象
			Document doc = builder.parse(is);
			//获取节点列表
			NodeList nodes = doc.getElementsByTagName("VALUE");
			int length = nodes.getLength();
			for(int i=0;i<length;i++) {
				String carNo = doc.getElementsByTagName("NO").item(i).getFirstChild().getNodeValue();
				String carAddr = doc.getElementsByTagName("ADDR").item(i).getFirstChild().getNodeValue();
				System.out.println("车牌号：" + carNo + " 车地址:" + carAddr);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Dom4j 方式
	 */
	@Test
	public void dom4jReader() {
		//spring获取资源
		Resource res = new ClassPathResource("addr.xml");
		InputStream is = null;
		try {
			//得到输入流
			is = res.getInputStream();
			//获取SAX读取对象
			SAXReader reader = new SAXReader();
			//获取文档对象
			org.dom4j.Document doc = reader.read(is);
			//获取根节点
			Element root = doc.getRootElement();
			//获取迭代器
			Iterator it = root.elementIterator("VALUE");
			//也可以不用迭代器，先获取一个List对象,然后遍历
			//List<Element> elementList = root.elements();
			while(it.hasNext()) {
				Element e = (Element) it.next();
				//sSystem.out.println(e.getName());
				System.out.println("车牌号：" + e.elementText("NO") + " 地址：" + e.elementText("ADDR"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * JDOM 方式
	 * @throws JDOMException 
	 */
	@Test
	public void JdomReader() throws IOException, JDOMException{
		
		SAXBuilder builder = new SAXBuilder();
		Resource res = new ClassPathResource("addr.xml");
		InputStream is = res.getInputStream();
		org.jdom2.Document doc = builder.build(is);
		//获取根节点
		org.jdom2.Element root = doc.getRootElement();
		//获取子节点集合
		List<org.jdom2.Element> list = root.getChildren();
		for(org.jdom2.Element e : list) {
			//System.out.println("车牌号：" + e.getChild("NO").getText() + " 地址：" + e.getChild("ADDR").getText());
			//替换以上写法
			System.out.println("车牌号：" + e.getChildText("NO") + " 地址：" + e.getChildText("ADDR"));
		}
	}
	
	/**
	 * SAX 方式
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	@Test
	public void SAXReader() throws ParserConfigurationException, SAXException, IOException {
		//SAX工厂对象
		Resource res = new ClassPathResource("addr.xml");
		InputStream is = res.getInputStream();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		MyHandler handler = new MyHandler();
		parser.parse(is, handler);
	}
	
	private static class MyHandler extends DefaultHandler{
		
		java.util.Stack tags = new java.util.Stack();
		
		public void characters(char ch[], int start, int length)   
				   throws SAXException {   
				   String tag = (String) tags.peek();   
				  if (tag.equals("NO")) {   
				    System.out.print("车牌号码：" + new String(ch, start, length));   
				   }   
//				  if (tag.equals("ADDR")) {   
//				    System.out.println("地址:" + new String(ch, start, length));   
//				   }   
				}   
				  
				public void startElement(String uri, String localName, String qName,   
				    Attributes attrs) {   
				   tags.push(qName);   
				} 
				
	}
	
	/**
	 * xml转化为对象
	 */
	@Test
	public void xmlToObject() {
		
		XStream xs = new XStream(new DomDriver());
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
					"<com.devil.seralize.Person>"+
						"<name>xiaohong</name>"+
						"<age>22</age>"+
						"<sex>男</sex>"+
					"</com.devil.seralize.Person>";
		Object obj = xs.fromXML(xml);
		Person person = (Person) obj;
		System.out.println(person.getName());
		
	}
	
	/**
	 * 对象转化为xml
	 * 
	 */
	@Test
	public void objToXml() {
		
		Person person = new Person("李白", 1005, "男");
		XStream xs = new XStream(new DomDriver());
		xs.alias("Person", Person.class);
		String xml = xs.toXML(person);
		System.out.println(xml);
	}
}
