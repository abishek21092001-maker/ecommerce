package com.example.ecommerce.dto;

import java.math.BigDecimal;



	

import java.util.ArrayList;
import java.util.List;



public class CartResponseDto {
	
	

	public Long getCartid() {
		return cartid;
	}
	public CartResponseDto() {
		super();
	}
	public CartResponseDto(Long cartid, List<CartResponseDto> cart, BigDecimal total, Long userid) {
		super();
		this.cartid = cartid;
		this.cart = cart;
		this.total = total;
		this.userid = userid;
	}
	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}
	public List<CartResponseDto> getCart() {
		return cart;
	}
	public void setCart(List<CartResponseDto> cart) {
		this.cart = cart;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	private Long cartid;
	private List<CartResponseDto> cart =new ArrayList<>();
	private BigDecimal total;
	private Long userid;



}
