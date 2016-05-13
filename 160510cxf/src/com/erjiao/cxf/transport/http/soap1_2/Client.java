package com.erjiao.cxf.transport.http.soap1_2;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.erjiao.cxf.frontend.jaxwsfrontend.codefirst.Order;
import com.erjiao.cxf.frontend.jaxwsfrontend.codefirst.OrderService;

public class Client {
	public static void main(String[] args) {
		try {
			//wsdl地址
			String wsdlurl = "file:f:/ws/soap1_2.wsdl";
			//名字空间
			String namespace = "http://soap1_2.http.transport.cxf.erjiao.com/";
			//服务名的限定对象
			QName serviceName = new QName(namespace, "OrderServiceImplService");
			//端口的限定名
			QName portName = new QName(namespace, "OrderServiceImplPort");
			
			//wsdl文档地址
			URL url = new URL(wsdlurl);
			//创建服务对象
			Service service = Service.create(url, serviceName);
			//通过服务对象创建端口对象
			OrderService os = service.getPort(portName, OrderService.class);
			//调用业务方法
			Order o = os.getOrder("N008");
			System.out.println(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
