package com.devil.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	public static void main(String[] args) throws IOException  {
	
		ServerSocket serverSocket = new ServerSocket(8088);
		Socket socket = null;
		int count  = 0;
		System.out.println("==========等待客户端连接==============");
		while(true) {
			socket = serverSocket.accept();
			Thread thread = new Thread(new ThreadServer(socket));
			thread.start();
			count ++;
			System.out.println("客户端数量 " + count );
		}
	}
}
