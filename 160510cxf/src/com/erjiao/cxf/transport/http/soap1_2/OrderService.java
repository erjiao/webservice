package com.erjiao.cxf.transport.http.soap1_2;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


/**
 * ����SEI(������ն˽ӿ�) 
 */
@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
