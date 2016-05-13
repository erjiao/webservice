package com.erjiao.cxf.frontend.simple;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * ����ǰ��: ��ʹ��ע��, ͨ��java�������ʵ��ws����
 */
public class Server {
	public static void main(String[] args) {
		//ʵ�����������
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		//����������bean
		ServerFactoryBean svrFactory = new ServerFactoryBean();
		//���÷�������(��Ҫ������ͷ�����ǩ��, ��������wsdl�ĵ�ֻҪ�ο��ӿڼ���)
		svrFactory.setServiceClass(OrderService.class);
		//���÷�����ַ
		svrFactory.setAddress("http://localhost:8080/OrderService");
		//���÷���bean
		svrFactory.setServiceBean(orderServiceImpl);
		//����������
		svrFactory.create();
	}
}
