package god.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleTest {
	private static Logger logger = Logger.getLogger(new SimpleTest().getClass());
	@Test
	public void readTxtContent(){
		
		//DataInputStream int = new Da
		try {
			File file = new File("E:\\mydev\\Struts2\\src\\test\\java\\test.txt");
			
			//BufferedInputStream bis = new BufferedInputStream(in);
			
			InputStreamReader read = new InputStreamReader(new FileInputStream(file),"utf-8"); 
			BufferedReader bfreader = new BufferedReader(read);
			//byte[] bt = new byte[1024];
			//int n = 0;
			String texStr = null;
			while((texStr=bfreader.readLine())!=null){
				logger.info("=======txt:"+texStr);
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write("if you love me,i will love you");
			bfreader.close();
			read.close();
			bw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void copyFile() throws IOException{
		File file = new File("E:\\mydev\\Struts2\\src\\test\\java\\test.txt");
		InputStream in = null;
		OutputStream out = null;
		try {
			 in = new FileInputStream(file);
			 out = new FileOutputStream(new File("E:\\javasoftware\\test.txt"));
			byte[] bt = new byte[1024];
			int length = 0;
			while((length=in.read(bt))!=-1){
				out.write(bt, 0, length);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			in.close();
			out.close();
		}
	}
}
