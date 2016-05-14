package com.erjiao.cxf.interceptor;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;


/**
 * ����SEI(������ն˽ӿ�) 
 * ����Զ���������������
 */
@WebService
@InInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingInInterceptor", 
		"com.erjiao.cxf.interceptor.MyServerInterceptor"})
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
}
