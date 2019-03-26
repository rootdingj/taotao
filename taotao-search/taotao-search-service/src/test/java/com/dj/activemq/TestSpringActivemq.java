package com.dj.activemq;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringActivemq {
	
	@Test
	public void testJmsTemplate() throws Exception{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		System.in.read();
	}

}
