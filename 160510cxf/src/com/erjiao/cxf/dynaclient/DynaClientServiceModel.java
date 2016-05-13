package com.erjiao.cxf.dynaclient;

import java.beans.PropertyDescriptor;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.ServiceInfo;

/**
 * ����ģ��, ������̬�ͻ���
 * (���������������˼��)
 */
public class DynaClientServiceModel {
	public static void main(String[] args) {
		//�ͻ��˹���
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		//�ͻ��˶���
		Client client = dcf.createClient("http://localhost:8080/OrderProcess?wsdl");
		//�ն�
		Endpoint endpoint = client.getEndpoint();
		//�õ���һ��������Ϣ
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		
		//ָ��soapbinding ���޶���
		QName bindingName = new QName("http://order.demo/", "OrderProcessServiceSoapBinding");
		
		//�õ��󶨵���Ϣ����
		BindingInfo binding = serviceInfo.getBinding(bindingName);
		
		//ָ�������޶���
		QName opName = new QName("http://order.demo/", "processOrder");
		
		//�õ��󶨵Ĳ�������
		BindingOperationInfo boi = binding.getOperation(opName);
		//������Ϣ
		BindingMessageInfo inputMessageInfo = null;
		if (!boi.isUnwrapped()) {
			//�õ�������������Ϣ
			inputMessageInfo = boi.getWrappedOperation().getInput();
		} else {
			//�õ������������Ϣ
			inputMessageInfo = boi.getUnwrappedOperation().getInput();
		}
		//�õ�������Ϣ�Ķ����������
		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		
		//ȡ�õ�һ����������
		MessagePartInfo partInfo = parts.get(0); // Input class is Order
		try {
			//�õ���Ϣ��������(������)
			Class<?> orderClass = partInfo.getTypeClass();
			//ʵ��������
			Object orderObject = orderClass.newInstance();
			// Populate the Order bean
			// ͨ����ʡ����, ��̬����ֵ
			PropertyDescriptor custProperty = new PropertyDescriptor("customerID",
					orderClass);
			custProperty.getWriteMethod().invoke(orderObject, "C001");
			PropertyDescriptor itemProperty = new PropertyDescriptor("itemID",
					orderClass);
			itemProperty.getWriteMethod().invoke(orderObject, "I001");
			PropertyDescriptor priceProperty = new PropertyDescriptor("price",
					orderClass);
			priceProperty.getWriteMethod().invoke(orderObject,
					Double.valueOf(100.00));
			PropertyDescriptor qtyProperty = new PropertyDescriptor("qty",
					orderClass);
			qtyProperty.getWriteMethod().invoke(orderObject, Integer.valueOf(20));
			
			
			//���÷��񷽷�, ��÷���ֵ
			Object[] result = client.invoke(opName, orderObject);
			System.out.println("The order ID is " + result[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
