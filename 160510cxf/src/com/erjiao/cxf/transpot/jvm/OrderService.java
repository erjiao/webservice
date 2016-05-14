package com.erjiao.cxf.transpot.jvm;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;


/**
 * 创建SEI(服务的终端接口) 
 */
@WebService
@Features(features={"org.apache.cxf.feature.LoggingFeature"})
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
