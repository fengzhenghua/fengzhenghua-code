package com.devil.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducerDemo {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
		ProducerService producerService = context.getBean(ProducerService.class);
		for(int i=0;i<100;i++){
			producerService.sendMessage("test:"+i);
		}
		
	}
}
