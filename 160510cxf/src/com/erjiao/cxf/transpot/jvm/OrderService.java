package com.erjiao.cxf.transpot.jvm;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;


/**
 * ����SEI(������ն˽ӿ�) 
 */
@WebService
@Features(features={"org.apache.cxf.feature.LoggingFeature"})
public interface OrderService {
	@WebMethod
	public Order getOrder(String orderNo);
	
}
