package com.example.ecommerce.dto;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.Product;

public class OrderItemReqestDto {
	
	  private Product product;
	  public OrderItemReqestDto() {
		super();
	}
	  public OrderItemReqestDto(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
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
	  private Integer quantity;


}
