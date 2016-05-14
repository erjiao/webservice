package com.erjiao.cxf.transport.http.soap1_2;

import javax.xml.ws.Endpoint;


/**
 * 
 */
public class Server {
	public static void main(String[] args) {
		OrderServiceImpl osi = new OrderServiceImpl();
		String url = "http://localhost:8888/OrderService";
		Endpoint.publish(url, osi);
	}
}
