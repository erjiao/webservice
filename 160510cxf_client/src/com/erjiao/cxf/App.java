package com.erjiao.cxf;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		//����spring ����
		ApplicationContext ac = new ClassPathXmlApplicationContext("client.xml");
//		HelloWorldService hws = (HelloWorldService) ac.getBean("helloWorldServiceClient");
//		System.out.println(hws.sayHello("erjiao"));
		
		OrderService os = (OrderService) ac.getBean("orderServiceClient");
		//Order order = os.getOrder("N000");
		//System.out.println(order.getOrderNo() + "," + order.getId() + "," + order.getPrice());
		
		Person p = os.getPersonByName("����");
		System.out.println(p);
		
	}
}
