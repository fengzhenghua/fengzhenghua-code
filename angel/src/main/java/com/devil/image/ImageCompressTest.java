package com.devil.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import org.junit.Test;

import sun.net.www.protocol.http.HttpURLConnection;

/**
 *@authur fengzhenghua 2017年10月4日 下午9:54:45
 *@ClassName ImageCompress
 *@Describtion
 */
public class ImageCompressTest {
		
	public static void main(String[] args) throws IOException {
		
		//File file = new File("D:\\twenty78.jpg");
		ImgCompressUtil imgUtil = new ImgCompressUtil();
		imgUtil.saveToLocal("D:\\twenty78.jpg");
		BufferedImage bi = imgUtil.resizeByWidth(960);
		File file = new File("D:\\temp.jpg");
		ImageIO.write(bi, "jpg", file);
		//ImgCompress ic = new ImgCompress("D:\\twenty78.jpg");
		//ic.resizeByWidth(960);
	}
	
	@Test
	public void getUrlImg() throws IOException {
		ImgCompressUtil imgUtil = new ImgCompressUtil();
		imgUtil.saveToFile("http://img.zcool.cn/community/0155365783719b0000012e7e73d0be.jpg@1280w_1l_2o_100sh.jpg");
		BufferedImage bi = imgUtil.resizeByWidth(960);
		File file = new File("D:\\lz.jpg");
		ImageIO.write(bi, "jpg", file);
	}
	
	@Test
	public void downloadImg() throws IOException {
		//File file = new File("http://img.zcool.cn/community/0155365783719b0000012e7e73d0be.jpg@1280w_1l_2o_100sh.jpg");
		URL url = new URL("http://img.zcool.cn/community/0155365783719b0000012e7e73d0be.jpg@1280w_1l_2o_100sh.jpg");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		int respcode = connection.getResponseCode();
		System.out.println(connection.getRequestMethod());
		System.out.println(respcode);
		connection.connect();
		
		InputStream in = connection.getInputStream();
		OutputStream out = new FileOutputStream(new File("D:\\lz1.jpg"));
		byte[] bytes = new byte[1024];
		int buffered = 0;
		while((buffered=in.read(bytes)) != -1) {
			out.write(bytes, 0, buffered);
		}
		in.close();
		out.close();
	}
}
