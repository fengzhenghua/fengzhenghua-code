package com.devil.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.WriteAbortedException;
import java.io.Writer;

import org.apache.log4j.Logger;

public class IOStream {
	
	private static Logger logger = Logger.getLogger(IOStream.class);
	
	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		try {
			if(!file.exists()){
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream out = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(out, "utf-8");
		BufferedWriter bfw = new BufferedWriter(writer);
		bfw.write("bfwriter");
		bfw.flush();//必须有
		//writer.append("中文输入");
		//writer.append("\r\n");
//		writer.append(" ");
//		writer.append("English");
//		writer.close();
//		out.close();
//		//
//		FileInputStream fis = new FileInputStream(file);
//		InputStreamReader reader = new InputStreamReader(fis,"utf-8");
//		StringBuffer sb = new StringBuffer();
//		while(reader.ready()){
//			sb.append((char)reader.read());
//		}
//		logger.info(sb.toString());
//		fis.close();
//		reader.close();
	}
	
	
}
