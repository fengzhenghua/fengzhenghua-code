package com.devil.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月7日 下午12:19:10
 *@ClassName Java2jad
 *@Describtion
 */
public class Java2jad {

	
	@Test
	public void java2jad() throws Exception {
		
		File file = new File("E:\\mydev\\angel\\src\\main\\java\\com\\devil\\JSON");
		if(!file.exists() || !file.isDirectory()) {
			throw new Exception("文件错误");
		}
		File[] files = file.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".java");
			}
		});
		
		File destFile = new File("D:\\jad");
		if(!destFile.exists()) 
			destFile.mkdirs();
		for(File f : files) {
			InputStream in = new FileInputStream(f);
			String destFileName = f.getName().replace(".java", ".jad");
			FileOutputStream out = new FileOutputStream(new File(destFile,destFileName));
			copyFile(in,out);
			in.close();
			out.close();
		}
		
		
	}
	
	public void copyFile(InputStream in,OutputStream out ) throws IOException {
		
		byte[] bytes = new byte[1024];
		int n = 0;
		if((n=in.read()) != -1) {
			out.write(bytes,0,n);
		}
	}
	
}
