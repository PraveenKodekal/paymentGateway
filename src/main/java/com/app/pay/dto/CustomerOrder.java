package com.app.pay.dto;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_orders")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String customerName;
	private String emailId;
	private String phonNum;
	private String product;
	private Integer amount;
	private String razorPayId;
	private String OrderStatus;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhonNum() {
		return phonNum;
	}
	public void setPhonNum(String phonNum) {
		this.phonNum = phonNum;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getRazorPayId() {
		return razorPayId;
	}
	public void setRazorPayId(String razorPayId) {
		this.razorPayId = razorPayId;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "CustomerOrder [customerId=" + customerId + ", customerName=" + customerName + ", emailId=" + emailId
				+ ", phonNum=" + phonNum + ", product=" + product + ", amount=" + amount + ", razorPayId=" + razorPayId
				+ ", OrderStatus=" + OrderStatus + "]";
	}
	
	
	

}
