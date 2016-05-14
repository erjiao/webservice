package com.erjiao.cxf.feature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * ¿Í»§¶Ë
 */
public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("client-beans.xml", Client.class);
		OrderService os = (OrderService) ac.getBean("orderServiceClient");
		Order order = os.getOrder("No0008");
		System.out.println(order);
	}
}
