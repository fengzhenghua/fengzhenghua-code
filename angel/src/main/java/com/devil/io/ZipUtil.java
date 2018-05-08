package com.devil.io;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

/**
 *@authur fengzhenghua 2017年9月25日 下午11:08:43
 *@ClassName ZipUtil
 *@Describtion
 */
public class ZipUtil {
	
	/**
	 * <p>对文件夹下文件进行压缩</p>
	 * @param localPathName
	 * @param savePathName
	 * @param fileName
	 * @return 
	 * @throws IOException 
	 */
	public boolean toZip(String localPathName, String savePathName, String fileName) throws IOException {
		
		File file = new File(localPathName);
		ZipOutputStream zipOut = null;
		if(!file.exists()) {
			System.out.println("本机文件目录不存在！");
		}else {
			File[] localFiles = new File(localPathName).listFiles();
			if(localFiles==null || localFiles.length<1) {
				System.out.println("本机目录下无文件存在！");
			}else {
				//ZipInputStream zi = new ZipInputStream(new FileInputStream(file));
				FileOutputStream fos = new FileOutputStream(new File(savePathName,fileName+".zip"));
				//CheckedOutputStream out = 
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				zipOut = new ZipOutputStream(bos);
				byte[] bytes = new byte[1024];
				for(File f : localFiles) {
					ZipEntry entry = new ZipEntry(f.getName());
					zipOut.putNextEntry(entry);
					FileInputStream fis = new FileInputStream(f);
					BufferedInputStream	bis = new BufferedInputStream(fis);
					int read = 0;
					while(-1 != (read=fis.read(bytes))) {
						zipOut.write(bytes, 0, read);
					}
				}
				
				
			}
			
			
		}
		zipOut.close();//一定要关闭流，否则输出错误
		return true;
		
	}
	
	@Test
	public void freeZip() {
		ZipInputStream zipIn = null;
		BufferedInputStream bin = null;
		String parent = "D:\\free";
		try {
			zipIn = new ZipInputStream(new FileInputStream("D:\\test.zip"));
			bin = new BufferedInputStream(zipIn);
			ZipEntry entry = null;
			while((entry = zipIn.getNextEntry()) != null) {
				
				File FileOut = new File(parent,entry.getName());
				if(!FileOut.exists()) {
					new File(FileOut.getParent()).mkdir();
				}
				FileOutputStream out = new FileOutputStream(FileOut);
				BufferedOutputStream bos = new BufferedOutputStream(out);
				byte[] bytes = new byte[1024];
				while(bin.read(bytes) != -1) {
					bos.write(bytes);
				}
				bos.close();
				out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				zipIn.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	@Test
	public void zipTest() throws IOException {
		String localPathName = "D:\\test";
		String savePathName = "D:\\";
		toZip(localPathName,savePathName,new File(localPathName).getName());
	}
	
	
}
