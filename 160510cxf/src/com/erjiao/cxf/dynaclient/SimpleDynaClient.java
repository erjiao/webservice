package com.erjiao.cxf.dynaclient;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * �򵥶�̬�ͻ���, ���䷽������ws
 */
public class SimpleDynaClient {
	
	public static void main(String[] args) {
		try {
			//����jaxws��̬�ͻ��˹���(����ģʽ)
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			//ͨ��wsdl�ĵ���ַ���������ͻ��˶���
			Client client = dcf.createClient("http://localhost:8080/OrderProcess?wsdl");
			//��̬�������ɵ�Order(wsdl�����ĵ��ж����, ���ǳ������)��
			Object order = Thread.currentThread().getContextClassLoader().loadClass("demo.order.Order").newInstance();
			//���setCustomerID �ķ���
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
