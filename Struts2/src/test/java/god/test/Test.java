package god.test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class Test {
	public static void main(String[] args) throws URISyntaxException, IOException, DocumentException {
//		JSONObject json = new JSONObject();
//		json.put("魏国", "曹操");
//		JSONObject json1 = new JSONObject();
//		json1.put("蜀国", "刘备");
//		JSONObject jsonObject = new JSONObject();
//		JSONObject jsonObjec1 = new JSONObject();
//		JSONObject jsonObjec2 = new JSONObject();
//		JSONArray jsonArray = new JSONArray();
//		jsonArray.add(json1);
//		jsonArray.add(json);
//		jsonObjec2.put("list", jsonArray);
//		jsonObjec1.put("d", "ddd");
//		jsonObject.put("a", "aa");
//		jsonObject.put("b", "bb");
//		jsonObject.put("c", jsonObjec1);
//		jsonObject.put("e", jsonObjec2);
//		System.out.println(jsonObject.toJSONString());
//		JSONObject jsonObj = JSONObject.parseObject(jsonObject.toJSONString());
//		System.out.println(jsonObj.get("e"));"http://imge.kugou.com/stdmusic/20160907/20160907190243690021.jpg"
//		URI uri = new URI("http","imge.kugou.com","/stdmusic/20160907/20160907190243690021.jpg","");
//		File file = new File(uri);
		
		//System.out.println(file.getName());
//		File file = new File()
//		URL url = new URL("http://imge.kugou.com/stdmusic/20160907/20160907190243690021.jpg");
//		File file = new File("E:\\mydev\\Struts2\\src\\test\\java\\test.txt");
//		System.out.println(file.getName());
		//InputStream ini = url.openStream();
//		String str = "<xml>"
//  +"<ToUserName>oHj9k1XD20pecDdKOeJo3MlErSgU</ToUserName>\n"
//  +"<FromUserName>gh_69ad81d3c473</FromUserName>\n"
//  +"<CreateTime>1499761524440</CreateTime>\n"
// +" <MsgType>music</MsgType>\n"
//  +"<music>\n"
//    +"<Title>王菲-因为爱情</Title>\n"
//	+"<Description>此音乐来自酷狗，由华哥抓取</Description>\n"
//   +" <MusicUrl>http://fs.web.kugou.com/cbb7cea56ecc24e54610698e6dac10f1/59648794/G004/M07/02/19/RA0DAFUICTOAa6V7ADUhSXdT9uo855.mp3</MusicUrl>\n"
//    +"<HQMusicUrl>http://fs.web.kugou.com/cbb7cea56ecc24e54610698e6dac10f1/59648794/G004/M07/02/19/RA0DAFUICTOAa6V7ADUhSXdT9uo855.mp3</HQMusicUrl>\n"
//    +"<ThumbMediaId>qGn-sEROBk-An4EY2DU50LDKeVj2dLIX4yIWktNxdWBzn2FZjRPIH1H-w4h__w03</ThumbMediaId>\n"
//  +"</music>\n"
//+"</xml>";
		String str1 = "abcde";
//		SAXReader reader = new SAXReader();
//		  ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
//		//获取文档节点
//		Document doc = reader.read(in);
//		Element root = doc.getRootElement();
//		List<Element> list =root.elements();
		System.out.println(str1.substring(0,str1.length()-1));
	}
}
