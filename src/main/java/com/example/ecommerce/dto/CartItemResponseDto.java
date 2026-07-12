package com.example.ecommerce.dto;

import java.math.BigDecimal;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Product;

public class CartItemResponseDto {
	 public CartItemResponseDto() {
		super();
	}
	 public CartItemResponseDto(Long cartItemId, Cart cart, Product product, Integer quantity, BigDecimal price) {
		super();
		this.cartItemId = cartItemId;
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	 public Long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	 private Long cartItemId;
	private Cart cart;
	 private Product product;
	 private Integer quantity;
	 private BigDecimal price;

}
