package com.jwkim.idus.dao;

public class Order {
	
	double orderNo;
	String productName;
	String orderDate;
	
	public double getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(double orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
