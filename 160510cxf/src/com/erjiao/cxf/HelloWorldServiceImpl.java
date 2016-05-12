package com.erjiao.cxf;

import javax.jws.WebService;

/**
 *  服务的实现类
 */
@WebService
public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String sayHello(String name) {
		return "hello " + name;
	}

}
