package com.erjiao.cxf.feature;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * ����SEI(������ն˽ӿ�) 
 * ����Զ���������������
 */
@WebService
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
}
