package com.erjiao.cxf.frontend.simple;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

/**
 * 创建简易前端客户端的api
 */
public class Client {

	public static void main(String[] args) {
		//创建客户端代理工厂bean
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		//设置工厂服务类(动态创建的客户端代理对象需要实现一个接口)
		factory.setServiceClass(OrderService.class);
		//指定服务地址
		factory.setAddress("http://localhost:8080/OrderService");
		//创建客户端代理对象
		OrderService client = (OrderService) factory.create();
		Order o = client.getOrder("11");
		System.out.println("The order ID is " + o);
	}
}
