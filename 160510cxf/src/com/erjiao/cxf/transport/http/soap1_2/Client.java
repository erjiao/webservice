package com.erjiao.cxf.transport.http.soap1_2;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.erjiao.cxf.frontend.jaxwsfrontend.codefirst.Order;
import com.erjiao.cxf.frontend.jaxwsfrontend.codefirst.OrderService;

public class Client {
	public static void main(String[] args) {
		try {
			//wsdl��ַ
			String wsdlurl = "file:f:/ws/soap1_2.wsdl";
			//���ֿռ�
			String namespace = "http://soap1_2.http.transport.cxf.erjiao.com/";
			//���������޶�����
			QName serviceName = new QName(namespace, "OrderServiceImplService");
			//�˿ڵ��޶���
			QName portName = new QName(namespace, "OrderServiceImplPort");
			
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
