package com.devil.activemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class AppConsumer {
	
	private static final String url = "tcp://47.94.94.39:61616";
	private static final String queueName = "queue-test";
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);//自动接收
		
		Destination destination = session.createQueue(queueName);
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		//创建一个监听器
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				// TODO Auto-generated method stub
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("接收消息："+textMessage.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}
