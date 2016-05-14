package com.erjiao.cxf.transpot.jvm;

import javax.xml.ws.Endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务器 
 */
public class TestJvm {
	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//在本地发布一个ws(jvm内部发布)
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
