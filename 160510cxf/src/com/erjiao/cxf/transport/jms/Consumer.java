package com.erjiao.cxf.transport.jms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��Ϣ��������, ������Ϣ 
 */
public class Consumer {
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("server-beans.xml", Consumer.class);
	}
}
