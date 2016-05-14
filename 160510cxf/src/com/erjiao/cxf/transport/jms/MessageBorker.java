package com.erjiao.cxf.transport.jms;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.store.memory.MemoryPersistenceAdapter;

/**
 * ��Ϣ�м��(����) 
 */
public class MessageBorker {

	public static void main(String[] args) {
		try {
			//������Ϣ�м��
			BrokerService broker = new BrokerService();
			//���ó־û�������(�ڴ�־û�����)
			broker.setPersistenceAdapter(new MemoryPersistenceAdapter());
			//������Ϣ�м����������
			broker.addConnector("tcp://localhost:61000");
			//�����м��
			broker.start();
			System.out.println("JMS broker ready ...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
