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
 * 服务模型, 开发动态客户端
 * (更能体现面向对象思想)
 */
public class DynaClientServiceModel {
	public static void main(String[] args) {
		//客户端工厂
		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
		//客户端对象
		Client client = dcf.createClient("http://localhost:8080/OrderProcess?wsdl");
		//终端
		Endpoint endpoint = client.getEndpoint();
		//得到第一个服务信息
		ServiceInfo serviceInfo = endpoint.getService().getServiceInfos().get(0);
		
		//指定soapbinding 的限定名
		QName bindingName = new QName("http://order.demo/", "OrderProcessServiceSoapBinding");
		
		//得到绑定的信息对象
		BindingInfo binding = serviceInfo.getBinding(bindingName);
		
		//指定操作限定名
		QName opName = new QName("http://order.demo/", "processOrder");
		
		//得到绑定的操作名称
		BindingOperationInfo boi = binding.getOperation(opName);
		//输入消息
		BindingMessageInfo inputMessageInfo = null;
		if (!boi.isUnwrapped()) {
			//得到包裹的输入消息
			inputMessageInfo = boi.getWrappedOperation().getInput();
		} else {
			//得到赤裸的输入消息
			inputMessageInfo = boi.getUnwrappedOperation().getInput();
		}
		//得到输入消息的多个参数部分
		List<MessagePartInfo> parts = inputMessageInfo.getMessageParts();
		
		//取得第一个参数部分
		MessagePartInfo partInfo = parts.get(0); // Input class is Order
		try {
			//得到消息的类型类(描述符)
			Class<?> orderClass = partInfo.getTypeClass();
			//实例化对象
			Object orderObject = orderClass.newInstance();
			// Populate the Order bean
			// 通过内省机制, 动态属性值
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
			
			
			//调用服务方法, 获得返回值
			Object[] result = client.invoke(opName, orderObject);
			System.out.println("The order ID is " + result[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
