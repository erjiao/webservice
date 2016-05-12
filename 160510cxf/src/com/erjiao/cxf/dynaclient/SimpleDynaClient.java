package com.erjiao.cxf.dynaclient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 简单动态客户端, 反射方法调用ws
 */
public class SimpleDynaClient {
	
	public static void main(String[] args) {
		try {
			//创建jaxws动态客户端工厂(工厂模式)
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			//通过wsdl文档地址创建创建客户端对象
			Client client = dcf.createClient("http://localhost:8080/OrderProcess?wsdl");
			//动态加载生成的Order(wsdl描述文档中定义的, 不是程序定义的)类
			Object order = Thread.currentThread().getContextClassLoader().loadClass("demo.order.Order").newInstance();
			//获得setCustomerID 的方法
			Method m1 = order.getClass().getMethod("setCustomerID", String.class);
			Method m2 = order.getClass().getMethod("setItemID", String.class);
			Method m3 = order.getClass().getMethod("setQty", Integer.class);
			Method m4 = order.getClass().getMethod("setPrice", Double.class);
			m1.invoke(order, "C001");
			m2.invoke(order, "I001");
			m3.invoke(order, 100);
			m4.invoke(order, 200.00);
			Object[] response = client.invoke("processOrder", order);
			System.out.println("Response is " + response[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
