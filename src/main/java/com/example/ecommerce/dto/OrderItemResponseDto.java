package com.example.ecommerce.dto;

import com.example.ecommerce.entity.Product;

public class OrderItemResponseDto {
	private Long orderItemId;
	 public OrderItemResponseDto() {
		super();
	}
	 public OrderItemResponseDto(Long orderItemId, Product product, Integer quantity) {
		super();
		this.orderItemId = orderItemId;
		this.product = product;
		this.quantity = quantity;
	}
	 public Long getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	 private Product product;
	 private Integer quantity;

}
