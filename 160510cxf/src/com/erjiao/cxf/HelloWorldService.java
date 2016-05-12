package com.erjiao.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface HelloWorldService {
	
	@WebMethod
	public String sayHello(String name);
	
}
