package com.devil.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月14日 上午1:26:15
 *@ClassName ChannelDemo
 *@Describtion
 */
public class ChannelDemo {
	
	@Test
	public void testChannel() throws IOException {
		
		RandomAccessFile aFile = new RandomAccessFile("D:\\nio.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		//分配一个新的48字节的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(48);
		buffer.putChar('f');
		int byteRead = 0;
		while(-1 != (byteRead=inChannel.read(buffer))) {//读到buffer里面
			System.out.println("Read " + byteRead);
			buffer.flip();//使缓冲区准备就读，它将限制设置为容量大小，将位置设置为 0。
			
			while(buffer.hasRemaining()) {//告知在当前位置和限制之间是否有元素。
				System.out.print((char)buffer.get());//一次读取一个字节
			}
			buffer.clear();//使缓冲区准备就写，它将限制设置为当前位置，然后将位置设置为 0。
			byteRead = inChannel.read(buffer);
			
		}
		aFile.close();
	}
}
