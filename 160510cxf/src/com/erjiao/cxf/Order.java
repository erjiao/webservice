package com.erjiao.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Order 
 */
@XmlRootElement(name="order_root", namespace="urn:jaxb:databinding:cxf:erjiao:cn")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
	
	@XmlAttribute(name="__id")
	private Integer id;
	@XmlElement(name="_orderNo")
	private String orderNo;
	@XmlTransient
	private float price;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
