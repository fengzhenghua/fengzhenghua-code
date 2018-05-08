package com.arthur.struts2.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
		
	  private static Logger logger = Logger.getLogger(new LoginAction().getClass());
	  private String user;
	  private String password;
	  private String name;
	  
	  public String execute(){
		  String ret = ERROR;
		  String input = INPUT;
		  
		  Connection conn = null;
		 
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
			  String URL= "jdbc:mysql://localhost/spring";
			  
			  conn = DriverManager.getConnection(URL, "root", "1234abcd");
			 String sql = "SELECT name FROM login WHERE";//根据查询的数据，只有一个值name
	         sql+=" user = ? AND password = ?";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, user);
	         ps.setString(2, password);
	         ResultSet rs = ps.executeQuery();
	         
	         while(rs.next()){
	        	 name = rs.getString(1);//取出查询的数据
	        	 logger.info("name="+name);
	        	 ret = SUCCESS;
	         }
	         return ret;
		} catch (SQLException e) {
			e.printStackTrace();
			return ret;

		} catch (ClassNotFoundException e) {
			logger.info("找不到此驱动");
			e.printStackTrace();
			return ret;
		}finally{
			 if (conn != null) {
		            try {
		               conn.close();
		            } catch (Exception e) {
		            	logger.info("关闭失败");
		            	}
		     }
		}
		  
	  }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	  
	  
}
