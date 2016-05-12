package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;

import javax.jws.WebService;

/**
 * OrderServiceImpl  µœ÷¿‡ 
 */
@WebService(name="orderservice_porttype", 
	targetNamespace="urn:codefirst:jaxws:erjiao.cn",
	serviceName="orderservice_servicename",
	portName="orderservice_portname")
public class OrderServiceImpl implements OrderService{
	public Order getOrder(String orderNo) {
		System.out.println("getOrder " + orderNo);
		Order o = new Order();
		o.setId(100);
		o.setOrderNo(orderNo);
		o.setPrice(500.76f);
		return o;
	}

}
