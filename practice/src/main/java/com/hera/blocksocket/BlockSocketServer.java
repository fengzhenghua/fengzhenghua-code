package com.hera.blocksocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 *@authur fengzhenghua 2017年11月4日 下午10:20:49
 *@ClassName BlockSocketServer
 *@Describtion 阻塞io
 */
public class BlockSocketServer {
	
	//监听端口
	private int port;
	//服务端socket
	private ServerSocket serverSocket;
	
	public void setPort(int port) {
		this.port = port;
	}
	
	//绑定端口号
	public void bindPort() {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//获取客户端socket
	public Socket getClientSocket()  {
		try {
			Socket socket = serverSocket.accept();
			return socket;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		BlockSocketServer blockSocketServer = new BlockSocketServer();
		blockSocketServer.setPort(8888);
		blockSocketServer.bindPort();
		System.out.println("----------------服务器启动开始-----------------------------");
		while(true) {
			Socket socket = blockSocketServer.getClientSocket();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					OutputStream out = null;
					try {
						out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.write("服务器发送消息：hello client!");
						writer.flush();
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}finally {
						try {
							socket.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
		}
	}
	
}
