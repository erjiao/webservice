package com.erjiao.cxf.transport.http.soap1_1;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * 创建SEI(服务的终端接口) 
 */
@WebService
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
