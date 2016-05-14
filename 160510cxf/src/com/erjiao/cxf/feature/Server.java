package com.erjiao.cxf.feature;

import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.common.gzip.GZIPFeature;

public class Server {

	public static void main(String[] args) {
		OrderService os = new OrderServiceImpl();
		//实例化GZipFeature 对象
		GZIPFeature gzip = new GZIPFeature();
		//阀门
		gzip.setThreshold(1);
		JaxWsServerFactoryBean server = new JaxWsServerFactoryBean();
		server.setServiceBean(os);
		server.setAddress("http://localhost:8080/feature/OrderServcie");
		//给服务器添加feature
		server.getFeatures().add(new LoggingFeature());
		server.getFeatures().add(gzip);
		server.create();
		System.out.println("Server ready....");
	}
}
