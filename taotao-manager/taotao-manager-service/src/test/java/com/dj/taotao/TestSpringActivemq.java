package com.dj.taotao;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TestSpringActivemq {
	
	@Test
	public void testJmsTemplate() throws Exception{
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:spring/applicationContext-activemq.xml");
		JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
		Destination destination = (Destination) context.getBean("test-queue");
		jmsTemplate.send(destination,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage message = session.createTextMessage("spring activemq queue test");
				return message;
			}
		});
	}

}
