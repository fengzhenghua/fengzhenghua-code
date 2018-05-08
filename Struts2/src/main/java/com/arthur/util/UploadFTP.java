package com.arthur.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.stream.FileImageInputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UploadFTP {
	
	private static Logger logger = Logger.getLogger(UploadFTP.class);
	@Test
	public void Upload() throws IOException{
		
		File file = new File("E:\\mydev\\Struts2\\upload\\cq.jpg");
		String imagefileFileName = "apple.jpg";
		FTPClient ftp = new FTPClient();
		String  hostName = "47.94.94.39";
		int port = 21;
		String userName ="root";
		String password = "zhenghua123@#";
		try{
			ftp.connect(hostName,port);
			ftp.login(userName, password);
			int reply = ftp.getReplyCode();
			logger.info("replyCode:"+reply);//返回530用户无权限，返回230则成功
			if (!FTPReply.isPositiveCompletion(reply)) {    
                ftp.disconnect();    
                return ;    
            } 
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);//指定上传文件类型
			//ftp.changeWorkingDirectory("\\home\\tomcat");//这种写法只会上传到对应用户根目录下
			ftp.changeWorkingDirectory("/home/tomcat");
			ftp.setControlEncoding("UTF-8");
			String remoteFileName = String.valueOf(System.currentTimeMillis()) + "_" + imagefileFileName;
			InputStream in = new FileInputStream(file);
			ftp.storeFile(remoteFileName, in);//文件你若是不指定就会上传到root目录下
		}catch(Exception e){
			logger.info("连接ftp服务器失败");
			e.printStackTrace();
		}
	}
}
