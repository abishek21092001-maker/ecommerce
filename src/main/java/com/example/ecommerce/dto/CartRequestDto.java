package com.example.ecommerce.dto;

import java.util.List;


import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Userentity;

public class CartRequestDto {
	


	public CartRequestDto() {
		super();
	}
	public CartRequestDto(Long userid, Long productid, List<CartItem> cartitem, Long total) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.cartitem = cartitem;
		this.total = total;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
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
	private Long userid;
	private Long productid;
	
	private List<CartItem> cartitem;
	private Long total;

}
