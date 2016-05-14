package com.erjiao.cxf.transport.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 消息的消费者, 处理消息 
 */
public class Consumer {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("server-beans.xml", Consumer.class);
	}
}
