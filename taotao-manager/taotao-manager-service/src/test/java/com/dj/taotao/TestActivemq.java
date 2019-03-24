package com.dj.taotao;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class TestActivemq {

	/**
	 * queue-Producer
	 */
	@Test
	public void testQueueProducer() throws Exception {
		// 1.创建一个工厂连接对象ConnectionFactory对象，需指定mq服务的ip和端口
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.106.125.36:61616");
		// 2.使用ConnectionFactory创建一个连接Connection对象
		Connection connection = factory.createConnection();
		// 3.开启连接。调用Connection对象的start方法
		connection.start();
		// 4.使用connection对象创建一个session对象
		// 参数1：是否开启分布式事物（一般不开）
		// 参数2：应该模式（选自动应答，手动应答需自己写代码）如果参数1为true，参数2自动忽略
//		connection.createSession(true, 0);
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.使用session对象创建一个destination对象（queue），两种形式（queue,topic）
		// 参数为消息队列的名称
		Queue queue = session.createQueue("test-queue");
		// 6.使用session对象创建一个producer对象
		MessageProducer producer = session.createProducer(queue);
		// 7.创建一个TextMessage对象
//		TextMessage testMessage = new TextMessage();
//		testMessage.setText("hello activemq");
		TextMessage textMessage = session.createTextMessage("hello activemq");
		// 8.发送消息
		producer.send(textMessage);
		// 9.关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 * queue-Consumer
	 */
	@Test
	public void testQueueConsumer() throws Exception {
		// 1.创建一个工厂连接对象ConnectionFactory对象，需指定mq服务的ip和端口
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.106.125.36:61616");
		// 2.使用ConnectionFactory创建一个连接Connection对象
		Connection connection = factory.createConnection();
		// 3.开启连接。调用Connection对象的start方法
		connection.start();
		// 4.使用connection对象创建一个session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.使用session对象创建一个destination对象，Destination应该和消息的发送端一致。
		Queue queue = session.createQueue("test-queue");
		// 6使用Session创建一个Consumer对象
		MessageConsumer consumer = session.createConsumer(queue);
		// 7.向Consumer对象中设置一个MessageListener对象，用来接收消息
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage testMessage = (TextMessage) message;
					try {
						String text = testMessage.getText();
						System.out.println("text: " + text);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		// 系统等待接收消息
//		while (true) {
//			Thread.sleep(100);
//		}
		System.in.read();
		// 关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

	/**
	 * topic-Producer
	 */
	@Test
	public void testTopicProducer() throws Exception {
		// 1.创建一个工厂连接对象
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.106.125.36:61616");
		// 2.创建一个连接Connection对象
		Connection connection = factory.createConnection();
		// 3.开启连接
		connection.start();
		// 4.创建一个session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.创建一个destination对象（topic），两种形式（queue,topic）
		Topic topic = session.createTopic("test-topic");
		// 6.创建一个producer对象
		MessageProducer producer = session.createProducer(topic);
		// 7.创建一个TextMessage对象
		TextMessage textMessage = session.createTextMessage("hello activemq topic");
		// 8.发送消息
		producer.send(textMessage);
		// 9.关闭资源
		producer.close();
		session.close();
		connection.close();
	}

	/**
	 * topic-Consumer
	 */
	@Test
	public void testTopicConsumer() throws Exception {
		// 1.创建一个工厂连接对象
		ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://47.106.125.36:61616");
		// 2.创建一个连接Connection对象
		Connection connection = factory.createConnection();
		// 3.开启连接
		connection.start();
		// 4.创建一个session对象
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		// 5.创建一个destination对象（topic），两种形式（queue,topic）
		Topic topic = session.createTopic("test-topic");
		// 6使用Session创建一个Consumer对象
		MessageConsumer consumer = session.createConsumer(topic);
		// 7.向Consumer对象中设置一个MessageListener对象，用来接收消息
		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				if (message instanceof TextMessage) {
					TextMessage testMessage = (TextMessage) message;
					try {
						String text = testMessage.getText();
						System.out.println("text: " + text);
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			}
		});
		System.out.println("消费者3。。。。。。");
		// 系统等待接收消息
		System.in.read();
		// 关闭资源
		consumer.close();
		session.close();
		connection.close();
	}

}
