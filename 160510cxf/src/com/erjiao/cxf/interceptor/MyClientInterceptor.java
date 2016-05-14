package com.erjiao.cxf.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 * �Զ���ͻ��������� 
 */
public class MyClientInterceptor extends AbstractSoapInterceptor{

	public MyClientInterceptor() {
		//д��׶�
		super(Phase.WRITE);
		addAfter(SoapPreProtocolOutInterceptor.class.getName());
	}
	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		System.out.println("MyClientInterceptor.handleMessage...");
	}

}
