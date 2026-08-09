package com.example.ecommerce.dto;

import java.math.BigDecimal;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Product;

public class CartItemRequestDto {
	

	 public CartItemRequestDto() {
		super();
	}
	 public CartItemRequestDto(Cart cart, Product product, Long quantity, BigDecimal price, Long subtotal) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.subtotal = subtotal;
	}
	 public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Long getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Long subtotal) {
		this.subtotal = subtotal;
	}
	 private Cart cart;
	 private Product product;
	 private Long quantity;
	 private BigDecimal price;
	 private Long subtotal;
	 

}
