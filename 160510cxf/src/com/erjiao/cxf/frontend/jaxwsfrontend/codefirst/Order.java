package com.erjiao.cxf.frontend.jaxwsfrontend.codefirst;


/**
 * Order 
 */
public class Order {
	
	private Integer id;
	private String orderNo;
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
