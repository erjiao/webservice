package com.erjiao.cxf.dynaclient;

import java.lang.reflect.Method;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 简单动态客户端, 反射方法调用ws
 * 分析wsdl文档, 通过反射方式动态加载类, 并动态传参, 并调用
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
			//获得setXxx 的方法
			Method m1 = order.getClass().getMethod("setCustomerID", String.class);
			Method m2 = order.getClass().getMethod("setItemID", String.class);
			Method m3 = order.getClass().getMethod("setQty", int.class);
			Method m4 = order.getClass().getMethod("setPrice", double.class);
			//调用对应的setXxx 方法
			m1.invoke(order, "C001");
			m2.invoke(order, "I001");
			m3.invoke(order, 100);
			m4.invoke(order, 200.00);
			//调用服务方法, 并传递参数order对象
			Object[] response = client.invoke("processOrder", order);
			//获得返回值
			System.out.println("Response is " + response[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
