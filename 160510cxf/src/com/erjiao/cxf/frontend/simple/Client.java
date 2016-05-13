package com.erjiao.cxf.frontend.simple;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

/**
 * ��������ǰ�˿ͻ��˵�api
 */
public class Client {

	public static void main(String[] args) {
		//�����ͻ��˴�����bean
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		//���ù���������(��̬�����Ŀͻ��˴��������Ҫʵ��һ���ӿ�)
		factory.setServiceClass(OrderService.class);
		//ָ�������ַ
		factory.setAddress("http://localhost:8080/OrderService");
		//�����ͻ��˴������
		OrderService client = (OrderService) factory.create();
		Order o = client.getOrder("11");
		System.out.println("The order ID is " + o);
	}
}
