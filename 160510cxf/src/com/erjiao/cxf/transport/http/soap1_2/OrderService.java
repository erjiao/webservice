package com.erjiao.cxf.transport.http.soap1_2;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;


/**
 * 创建SEI(服务的终端接口) 
 */
@WebService
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
