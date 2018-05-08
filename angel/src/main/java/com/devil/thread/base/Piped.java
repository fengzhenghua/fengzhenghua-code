package com.devil.thread.base;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 *@authur fengzhenghua 2017年9月13日 下午10:49:22
 *@ClassName Piped
 *@Describtion 多线程管道之间的数据传输，传输媒介为内存。
 */
public class Piped {
	
	public static void main(String[] args) throws IOException {
		PipedReader in = new PipedReader();
		PipedWriter out = new PipedWriter();
		//输入流与输出流进行绑定，否则报错IOException
		out.connect(in);
		Thread printThread = new Thread(new Print(in),"PrintThread");
		printThread.start();
		int receive = 0;
		try {
			while((receive=System.in.read()) != -1) {
				out.write(receive);
			}
		}finally {
			out.close();
		}
	}
	
	static class Print implements Runnable {
		
		private PipedReader pipedReader;
		
		
		
		public Print(PipedReader pipedReader) {
			super();
			this.pipedReader = pipedReader;
		}



		@Override
		public void run() {
			int receive = 0;
			try {
				while((receive=pipedReader.read()) != -1) {
					System.out.print((char) receive);
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
