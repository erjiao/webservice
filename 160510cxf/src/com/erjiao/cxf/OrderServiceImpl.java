package com.erjiao.cxf;

import javax.jws.WebService;

/**
 * OrderServiceImpl  µœ÷¿‡ 
 */
@WebService
public class OrderServiceImpl implements OrderService{
	public Order getOrder(String orderNo) {
		System.out.println("getOrder " + orderNo);
		Order o = new Order();
		o.setId(100);
		o.setOrderNo(orderNo);
		o.setPrice(500.76f);
		return o;
	}

	@Override
	public Person getPersonByName(String name) {
		System.out.println("getPersonByName" + name);
		Person p = new Person();
		p.setId(100);
		p.setName(name);
		return p;
	}

}
