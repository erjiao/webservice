package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.OutInterceptors;

/**
 * 创建SEI(服务的终端接口) 
 */
@WebService(name="orderservice_porttype", 
		targetNamespace="urn:codefirst:jaxws:erjiao.cn",
		serviceName="orderservice_servicename",
		portName="orderservice_portname")
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL, parameterStyle=ParameterStyle.BARE)
@InInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingInInterceptor"})
@OutInterceptors(interceptors={"org.apache.cxf.interceptor.LoggingOutInterceptor"})
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
