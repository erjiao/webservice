package com.erjiao.cxf.interceptor;

import org.apache.cxf.frontend.ClientProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户端
 */
public class Client {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"client-beans.xml", Client.class);
		OrderService os = (OrderService) ac.getBean("orderServiceClient");
		//创建客户端拦截器对象
		MyClientInterceptor clientInterceptor = new MyClientInterceptor();
		//通过客户端代理类创建客户端的包装对象
		org.apache.cxf.endpoint.Client cxfClient = ClientProxy.getClient(os);
		//得到客户端出拦截器集合, 并添加拦截器对象
		cxfClient.getOutInterceptors().add(clientInterceptor);
		
		//调用os方法
		Order order = os.getOrder("No99090");
		System.out.println(order);
	}
}
