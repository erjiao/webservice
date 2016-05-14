package com.erjiao.cxf.interceptor;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.interceptor.InInterceptors;


/**
 * 创建SEI(服务的终端接口) 
 * 添加自定义拦截器给服务
 */
@WebService
@InInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingInInterceptor", 
		"com.erjiao.cxf.interceptor.MyServerInterceptor"})
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
}
