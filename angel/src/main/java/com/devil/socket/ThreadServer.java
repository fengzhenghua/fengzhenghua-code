package com.devil.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *@authur fengzhenghua 2017年9月17日 下午10:51:56
 *@ClassName ThreadServer
 *@Describtion 线程类，把客户端监听到socket传递进来处理
 */
public class ThreadServer implements Runnable{

	
	OutputStream out = null;
	PrintWriter print = null;
	InputStream in = null;
	BufferedReader br = null;
	InputStreamReader isr = null;
	//初始化服务端接收到的socket
	private Socket socket ;
	
	
	public ThreadServer(Socket socket) {
		super();
		this.socket = socket;
	}



	@Override
	public void run() {
		try {
		
			in = socket.getInputStream();
			isr = new  InputStreamReader(in);
			br = new BufferedReader(isr);
			String info = br.readLine();
			while(info !=null){
				System.out.println("客户端消息："+info);
				info = br.readLine();
			}
			//响应给客户端
			out = socket.getOutputStream();
			print = new PrintWriter(out);
			print.write("客户端你好，这是我给你的数据");
			print.flush();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			print.close();
		}
		
//		socket.shutdownInput();
//		socket.shutdownOutput();
		
		
	}
	
	
}
