package com.devil.seralize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *@authur fengzhenghua 2017年8月28日 下午11:24:27
 *@ClassName SeralizTool
 *@Describtion
 */
public class SeralizTool {
	
	/**
	 * 序列化为字节流
	 */
	public static byte[] seralize(Object obj) {
		
		byte[] bytes = null;
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		try {
			bo = new ByteArrayOutputStream();
		    oo = new ObjectOutputStream(bo);
			oo.writeObject(obj);
			
			bytes = bo.toByteArray();
			
			return bytes;
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			try {
				bo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				oo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return bytes;
	}
	
	/**
	 * 字节反序列化
	 */
	public static Object byteToObj(byte[] bytes) {
		
		Object obj = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		
		try {
			bi = new ByteArrayInputStream(bytes);
			oi = new ObjectInputStream(bi);
			
			obj = oi.readObject();
			return obj;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				bi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				oi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
