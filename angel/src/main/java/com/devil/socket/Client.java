package com.devil.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost",8888);
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.write("小明和小强");
		pw.flush();
		socket.shutdownOutput();
		//接收服务器信息
		InputStream in = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(reader);
		String data = br.readLine();
		while(data !=null){
			System.out.println("接收的客户端信息："+data);
			data = br.readLine();
		}
		//String str = new String("aa".getBytes("gbk"),"UTF-8");
		//关闭资源
		in.close();
		reader.close();
		br.close();
		socket.close();
		out.close();
		pw.close();
	}
}
