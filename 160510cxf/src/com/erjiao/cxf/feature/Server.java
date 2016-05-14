package com.erjiao.cxf.feature;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPFeature;

public class Server {

	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//ʵ����GZipFeature ����
		GZIPFeature gzip = new GZIPFeature();
		//����
		gzip.setThreshold(1);
		JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
		server.setServiceBean(os);
		server.setAddress("http://localhost:8080/feature/OrderServcie");
		//�����������feature
		server.getFeatures().add(new LoggingFeature());
		server.getFeatures().add(gzip);
		server.create();
		System.out.println("Server ready....");
	}
}
