package com.erjiao.cxf.interceptor;

import org.apache.cxf.frontend.ClientProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * �ͻ���
 */
public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"client-beans.xml", Client.class);
		OrderService os = (OrderService) ac.getBean("orderServiceClient");
		//�����ͻ�������������
		MyClientInterceptor clientInterceptor = new MyClientInterceptor();
		//ͨ���ͻ��˴����ഴ���ͻ��˵İ�װ����
		org.apache.cxf.endpoint.Client cxfClient = ClientProxy.getClient(os);
		//�õ��ͻ��˳�����������, ���������������
		cxfClient.getOutInterceptors().add(clientInterceptor);
		
		//����os����
		Order order = os.getOrder("No99090");
		System.out.println(order);
	}
}
