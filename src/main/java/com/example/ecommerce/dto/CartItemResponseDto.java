package com.example.ecommerce.dto;

import java.math.BigDecimal;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Product;

public class CartItemResponseDto {

 public CartItemResponseDto() {
		super();
	}
 public CartItemResponseDto(BigDecimal price, BigDecimal quantity, BigDecimal subtotal, Long cartid,
			Long cartitemid) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.subtotal = subtotal;
		Cartid = cartid;
		this.cartitemid = cartitemid;
	}
 public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
	public Long getCartid() {
		return Cartid;
	}
	public void setCartid(Long cartid) {
		Cartid = cartid;
	}
	public Long getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(Long cartitemid) {
		this.cartitemid = cartitemid;
	}
 private BigDecimal price ;
 private BigDecimal quantity;
 private BigDecimal subtotal;
 private Long Cartid;
 private Long cartitemid;
 

}
