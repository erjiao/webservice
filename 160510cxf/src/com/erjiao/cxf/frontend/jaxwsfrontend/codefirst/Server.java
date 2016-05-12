package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;

import javax.xml.ws.Endpoint;
/**
 * 发布ws, 前端, 通过编程方式发布ws, 快捷
 * @WebService
 * @WebMethod
 * Endpoint.publish()
 */
public class Server {
	
	public static void main(String[] args) {
		OrderServiceImpl osi = new OrderServiceImpl();
		String url = "http://localhost:9090/OrderService";
		Endpoint.publish(url, osi);
	}
	
}
