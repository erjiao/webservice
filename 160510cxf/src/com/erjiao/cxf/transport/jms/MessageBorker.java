package com.erjiao.cxf.transport.jms;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;

/**
 * 消息中间件(代理) 
 */
public class MessageBorker {

	public static void main(String[] args) {
		try {
			//创建消息中间件
			BrokerService broker = new BrokerService();
			//设置持久化适配器(内存持久化适配)
			broker.setPersistenceAdapter(new MemoryPersistenceAdapter());
			//设置消息中间件的连接器
			broker.addConnector("tcp://localhost:61000");
			//启动中间件
			broker.start();
			System.out.println("JMS broker ready ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
