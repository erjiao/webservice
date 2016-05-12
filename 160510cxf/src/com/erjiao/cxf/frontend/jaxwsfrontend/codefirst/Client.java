package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class Client {
	 public static void main(String[] args) {
		try {
			//wsdl地址
			String wsdlurl = "http://localhost:9090/OrderService?wsdl";
			//名字空间
			String namespace = "urn:codefirst:jaxws:erjiao.cn";
			//服务名的限定对象
			QName serviceName = new QName(namespace, "orderservice_servicename");
			//端口的限定名
			QName portName = new QName(namespace, "orderservice_portname");
			
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
