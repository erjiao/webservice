package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	 public static void main(String[] args) {
		try {
			//wsdl��ַ
			String wsdlurl = "http://localhost:9090/OrderService?wsdl";
			//���ֿռ�
			String namespace = "urn:codefirst:jaxws:erjiao.cn";
			//���������޶�����
			QName serviceName = new QName(namespace, "orderservice_servicename");
			//�˿ڵ��޶���
			QName portName = new QName(namespace, "orderservice_portname");
			
			//wsdl�ĵ���ַ
			URL url = new URL(wsdlurl);
			//�����������
			Service service = Service.create(url, serviceName);
			//ͨ��������󴴽��˿ڶ���
			OrderService os = service.getPort(portName, OrderService.class);
			//����ҵ�񷽷�
			Order o = os.getOrder("N008");
			System.out.println(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
