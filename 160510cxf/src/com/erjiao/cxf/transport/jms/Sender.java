package com.erjiao.cxf.transport.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ��Ϣ���ͷ�,��Ϣ������
 */
public class Sender {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"client-beans.xml", Sender.class);
		OrderService os = (OrderService) ac.getBean("orderServiceClient");
		System.out.println("---------------------------------");
		Order order = os.getOrder("N009");
		System.out.println(order);
	}
}
