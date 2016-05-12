
package com.erjiao.cxf.frontend.jaxwsfrontend.contractfirst;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 2.5.9
 * 2016-05-12T21:34:50.155+08:00
 * Generated source version: 2.5.9
 * ���ɶ���������
 */
 
public class OrderProcess_OrderProcessPort_Server{

    protected OrderProcess_OrderProcessPort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new OrderProcessImpl();
        String address = "http://localhost:8080/OrderProcess";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new OrderProcess_OrderProcessPort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}