package com.erjiao.cxf.webservicecontext;

import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.message.Message;

/**
 * OrderServiceImpl ʵ���� 
 */
@WebService
public class OrderServiceImpl implements OrderService{
	
	WebServiceContext wsc;

	/**
	 * ע��ws �����Ķ���
	 */
	@Resource
	public void setWsc(WebServiceContext wsc) {
		this.wsc = wsc;
	}

	MessageContext mc;
	
	public Order getOrder(String orderNo) {
		//ͨ��ws�����ĵõ���Ϣ������
		mc = wsc.getMessageContext();
		for (Entry<String, Object> entry : mc.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			System.out.println(key + "=" + value);
		}
		//�õ���������
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
