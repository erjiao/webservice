package com.erjiao.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * ����SEI(������ն˽ӿ�) 
 */
@WebService
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
	@WebMethod
	public Person getPersonByName(String name);
}
