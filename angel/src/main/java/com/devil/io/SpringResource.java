package com.devil.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class SpringResource{
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("src/main/java/com/devil/io/test3.txt");
		File f2 = new File("a.json");
		InputStream in = new FileInputStream(file);
		System.out.println(file.getCanonicalPath());
		Resource resource = new ClassPathResource("file1.txt");
//		FileSystemResource fsr = new FileSystemResource(new File("file1.txt"));
//		fsr.get
		InputStream is = resource.getInputStream();
		//ByteArrayOutputStream bao = new ByteArrayOutputStream();
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		String data = br.readLine();
		int length = 0;
		/*while((length=is.read())!=-1){
			bao.write(length);
		}*/
		while(data != null){
			System.out.println(data);
			data =br.readLine();
			
		}
		OutputStream out = new  FileOutputStream(f2);
		OutputStreamWriter osw = new OutputStreamWriter(out, "utf-8");
		BufferedWriter bw = new BufferedWriter(osw);
		bw.flush();
		bw.write("iloveyou dddddddddddddddddddd");
		bw.close();
		//FileWriter fw = new FileWriter("new")
		System.out.println(resource.getFilename());
		//System.out.println(bao.toString());
	}
	
}
