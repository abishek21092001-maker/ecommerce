package com.example.ecommerce.dto;

public class CartResponseDto {
	
	private Long total;

	public CartResponseDto() {
		super();
	}

	public CartResponseDto(Long total) {
		super();
		this.total = total;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

}
