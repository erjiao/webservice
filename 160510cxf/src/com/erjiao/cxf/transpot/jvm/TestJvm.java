package com.erjiao.cxf.transpot.jvm;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ������ 
 */
public class TestJvm {
	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//�ڱ��ط���һ��ws(jvm�ڲ�����)
		Endpoint.publish("local://OrderService", os);
		
		new Thread() {
			public void run() {
				System.out.println("--------------");
				ApplicationContext ac = new ClassPathXmlApplicationContext(
						"client-beans.xml", TestJvm.class);
				OrderService oss = (OrderService) ac.getBean("orderServiceClient");
				Order order = oss.getOrder("No9999");
				System.out.println(order);
			}
		}.start();
	}
}
