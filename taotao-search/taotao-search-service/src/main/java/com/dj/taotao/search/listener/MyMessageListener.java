package com.dj.taotao.search.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 
 * @ClassName: MyMessageListener
 * @Description: 接收activemq发送的消息
 * @author Steven
 * @date 2019年3月26日
 */
public class MyMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TextMessage text = (TextMessage) message;
			System.out.println("myMessageListener text is : " + text.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
