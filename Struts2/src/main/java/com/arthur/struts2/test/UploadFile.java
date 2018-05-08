package com.arthur.struts2.test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadFile extends ActionSupport{
	   private File myFile;
	   private String myFileContentType;
	   private String myFileFileName;
	   private String destPath;
	   private static final String SUCCESS = "success";
	   private static final String ERROR = "error";
	   public String execute()
	   {
//		   Map<String,Object> map = ActionContext.getContext().getParameters();//获取参数
//		   String[] myFileFileName = (String[]) map.get("myFileFileName");
	      /* Copy file to a safe location */
	      destPath = "E:\\mydev\\Struts2\\upload";
		   //destPath ="47.94.94.39\\home\tomcat";
	      try{
	     	 System.out.println("Src File name: " + myFile);
	     	 System.out.println("Dst File name: " + myFileFileName);
	     	    	 
	     	 File destFile  = new File(destPath, myFileFileName);
	    	 FileUtils.copyFile(myFile, destFile);
	  
	      }catch(IOException e){
	         e.printStackTrace();
	         return ERROR;
	      }

	      return SUCCESS;
	   }
	   
	   //校验
//	   @Override
//	public void validate() {
//		if(name == null && "".equals(name)){
//			addFieldError("name", "用户名不能为空");
//		}
//		super.validate();
//	}
	public File getMyFile() {
	      return myFile;
	   }
	   public void setMyFile(File myFile) {
	      this.myFile = myFile;
	   }
	   public String getMyFileContentType() {
	      return myFileContentType;
	   }
	   public void setMyFileContentType(String myFileContentType) {
	      this.myFileContentType = myFileContentType;
	   }
	   public String getMyFileFileName() {
	      return myFileFileName;
	   }
	   public void setMyFileFileName(String myFileFileName) {
	      this.myFileFileName = myFileFileName;
	   }
	}