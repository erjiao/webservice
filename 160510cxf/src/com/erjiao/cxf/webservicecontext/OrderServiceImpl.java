package com.erjiao.cxf.webservicecontext;

import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.message.Message;

/**
 * OrderServiceImpl 实现类 
 */
@WebService
public class OrderServiceImpl implements OrderService{
	
	WebServiceContext wsc;

	/**
	 * 注入ws 上下文对象
	 */
	@Resource
	public void setWsc(WebServiceContext wsc) {
		this.wsc = wsc;
	}

	MessageContext mc;
	
	public Order getOrder(String orderNo) {
		//通过ws上下文得到消息上下文
		mc = wsc.getMessageContext();
		for (Entry<String, Object> entry : mc.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "=" + value);
		}
		//得到操作名称
		Object oo = mc.get(Message.WSDL_OPERATION);
		System.out.println(oo);
		System.out.println(wsc);
		System.out.println("getOrder " + orderNo);
		Order o = new Order();
		o.setId(100);
		o.setOrderNo(orderNo);
		o.setPrice(500.76f);
		return o;
	}

}
