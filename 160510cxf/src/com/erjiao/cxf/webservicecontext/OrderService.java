package com.erjiao.cxf.webservicecontext;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * ����SEI(������ն˽ӿ�) 
 */
@WebService
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
