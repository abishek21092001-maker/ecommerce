package com.example.ecommerce.dto;

import java.math.BigDecimal;


public class CartRequestDto {

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
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	
	public CartRequestDto() {
		super();
	}
	public CartRequestDto(Long userid, Long productid, BigDecimal quantity) {
		super();
		this.userid = userid;
		this.productid = productid;
		this.quantity = quantity;
		
	}
	private Long userid;
	private Long productid;
	
	private BigDecimal quantity;
	


}
