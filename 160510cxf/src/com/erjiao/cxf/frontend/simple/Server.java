package com.erjiao.cxf.frontend.simple;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * 简易前端: 不使用注解, 通过java反射机制实现ws发布
 */
public class Server {
	public static void main(String[] args) {
		//实例化服务对象
		OrderServiceImpl orderServiceImpl = new OrderServiceImpl();
		//服务器工厂bean
		ServerFactoryBean svrFactory = new ServerFactoryBean();
		//设置服务器类(需要的是类和方法的签名, 对于生成wsdl文档只要参考接口即可)
		svrFactory.setServiceClass(OrderService.class);
		//设置发布地址
		svrFactory.setAddress("http://localhost:8080/OrderService");
		//设置服务bean
		svrFactory.setServiceBean(orderServiceImpl);
		//创建服务器
		svrFactory.create();
	}
}
