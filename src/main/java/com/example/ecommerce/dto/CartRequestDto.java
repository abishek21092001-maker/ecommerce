package com.example.ecommerce.dto;

import java.util.List;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.User;

public class CartRequestDto {
	
	public CartRequestDto() {
		super();
	}
	
	public CartRequestDto(User user, List<CartItem> cartitem, Long total) {
		super();
		this.user = user;
		this.cartitem = cartitem;
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartItem> getCartitem() {
		return cartitem;
	}
	public void setCartitem(List<CartItem> cartitem) {
		this.cartitem = cartitem;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	private User user;
	
	private List<CartItem> cartitem;
	private Long total;

}
