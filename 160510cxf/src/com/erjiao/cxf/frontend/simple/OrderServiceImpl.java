package com.erjiao.cxf.frontend.simple;


/**
 * OrderServiceImpl ʵ���� 
 */
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
