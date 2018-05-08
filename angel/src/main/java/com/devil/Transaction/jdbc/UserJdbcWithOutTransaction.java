package com.devil.Transaction.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

//@Service("userService")
public class UserJdbcWithOutTransaction {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addAge(String userName,String age){
		String sql = "UPDATE user u set u.age=? where name=? ";
		jdbcTemplate.update(sql,age,userName);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbcWithOutTX.xml");
		UserJdbcWithOutTransaction service = (UserJdbcWithOutTransaction) ctx.getBean("userService");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		BasicDataSource basicDataSource = (BasicDataSource) jdbcTemplate.getDataSource();
		System.out.println("autoCommit:"+basicDataSource.getDefaultAutoCommit());
		jdbcTemplate.execute("insert into user(name,age,sex) values('小明','12','男')");
		service.addAge("tom", "18");
		//int age = (int)jdbcTemplate.queryForInt("select * from user where name ='tom' ");
		//System.out.println(age);
	}
	
	
}
