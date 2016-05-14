package com.erjiao.cxf.feature;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * 创建SEI(服务的终端接口) 
 * 添加自定义拦截器给服务
 */
@WebService
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
}
