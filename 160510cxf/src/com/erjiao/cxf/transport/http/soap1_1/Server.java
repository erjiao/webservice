package com.erjiao.cxf.transport.http.soap1_1;

import javax.xml.ws.Endpoint;
/**
 * 
 */
public class Server {
	public static void main(String[] args) {
		OrderServiceImpl osi = new OrderServiceImpl();
		String url = "http://localhost:9090/OrderService";
		Endpoint.publish(url, osi);
	}
}
