package com.erjiao.cxf.interceptor;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

/**
 * 自定义服务器拦截器
 */
public class MyServerInterceptor extends AbstractSoapInterceptor{
	public MyServerInterceptor() {
		super(Phase.PRE_INVOKE);
	}
	
	@Override
	public void handleMessage(SoapMessage arg0) throws Fault {
		System.out.println("MyServerInterceptor.handleMessage...");
	}
}
