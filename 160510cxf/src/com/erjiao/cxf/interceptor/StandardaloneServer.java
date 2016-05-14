package com.erjiao.cxf.interceptor;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class StandardaloneServer {

	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//jaxws 服务器工厂bean
		JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
		//设置服务器bean
		server.setServiceBean(os);
		//设置发布地址
		server.setAddress("http://localhost:8080/OrderService");
		//创建服务器(直接启动)
		server.create();
		System.out.println("Server ready....");
	}

}
