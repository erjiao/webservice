package com.erjiao.cxf;

import javax.jws.WebService;

/**
 *  �����ʵ����
 */
@WebService
public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

}
