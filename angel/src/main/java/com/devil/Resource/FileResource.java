package com.devil.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;

public class FileResource {
	public static void main(String[] args) {
		
		try {
		String filePath = "E:\\mydev\\angel\\src\\mian\\resource\\file1.txt";
		//1.使用绝对路径
		WritableResource res1 = new PathResource(filePath);
		
		//2.使用类路径
		Resource res2 = new ClassPathResource("file1.txt");
		
		//3.使用WritableResource接口写资源文件
		OutputStream stream1 = res1.getOutputStream();
		stream1.write("我的世界不再有你".getBytes());
		
		//4.使用Resource接口读资源文件
		InputStream ins1 = res1.getInputStream();
		InputStream ins2 = res2.getInputStream();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int i;
		while((i=ins1.read())!=-1){
			baos.write(i);
		}
		System.out.println(baos.toString());
		System.out.println(stream1.toString());
		
		System.out.println("res1:"+res1.getFilename());
		System.out.println("res2:"+res2.getFilename());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
