package com.erjiao.cxf.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapPreProtocolOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 * 自定义客户端拦截器 
 */
public class MyClientInterceptor extends AbstractSoapInterceptor{

	public MyClientInterceptor() {
		//写入阶段
		super(Phase.WRITE);
		addAfter(SoapPreProtocolOutInterceptor.class.getName());
	}
	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		System.out.println("MyClientInterceptor.handleMessage...");
	}

}
