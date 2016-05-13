package com.erjiao.cxf.transport.http.soap1_1;

import javax.jws.WebService;
import javax.xml.ws.BindingType;


/**
 * OrderServiceImpl  µœ÷¿‡ 
 */
@WebService
@BindingType
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
