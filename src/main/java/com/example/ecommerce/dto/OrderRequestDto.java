package com.example.ecommerce.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.ecommerce.entity.OrderItem;

public class OrderRequestDto {
	public OrderRequestDto() {
		super();
	}
	public OrderRequestDto(BigDecimal totalAmount, String shippingAddress, String paymentMethod, String orderStatus,
			LocalDateTime orderDate, List<OrderItem> orderItems) {
		super();
		this.totalAmount = totalAmount;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
		this.orderItems = orderItems;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	private BigDecimal totalAmount;
	
    private String shippingAddress;
    
    private String paymentMethod;
    
    private String orderStatus;
    private LocalDateTime orderDate;
    private List<OrderItem> orderItems;

}
