package com.example.ecommerce.dto;

import java.math.BigDecimal;

public class ProductResponseDto {
	
	public ProductResponseDto() {
		super();
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public ProductResponseDto(String product_id, String name, String description, BigDecimal price, int stock,
			String imageurl) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageurl = imageurl;
	}
	private String product_id;

	 private String name;
		
		private String description;
		
		private BigDecimal price;
		
		private int stock; 
		private String imageurl;

}
