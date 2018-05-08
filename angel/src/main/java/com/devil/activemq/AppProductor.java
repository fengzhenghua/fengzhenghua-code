package com.devil.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppProductor {
	
	private static final String url = "tcp://47.94.94.39:61616";
	private static final String queueName = "queue-test";
	public static void main(String[] args) throws JMSException {
		
		//1.创建ConnectFactory
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		//2.创建Connection
		Connection connection = connectionFactory.createConnection();
		
		//3.启动连接
		connection.start();
		
		//4.创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//5.创建一个目标
		Destination destination = session.createQueue(queueName);
		
		//6.创建一个生产者
		MessageProducer messageProducer = session.createProducer(destination);
		
		for(int i=0;i<100;i++){
			//7.创建消息
			TextMessage textMessage = session.createTextMessage("test"+i);
			messageProducer.send(textMessage);
			System.out.println("发送消息:"+textMessage.getText());
		}
		
		connection.close();
	}
}
