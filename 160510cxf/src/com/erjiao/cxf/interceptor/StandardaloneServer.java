package com.erjiao.cxf.interceptor;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class StandardaloneServer {

	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//jaxws ����������bean
		JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
		//���÷�����bean
		server.setServiceBean(os);
		//���÷�����ַ
		server.setAddress("http://localhost:8080/OrderService");
		//����������(ֱ������)
		server.create();
		System.out.println("Server ready....");
	}

}
