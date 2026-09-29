package com.example.ecommerce.dto;

import java.math.BigDecimal;

public class ProductRequestDto {
  
	public ProductRequestDto() {
		super();
	}
	public ProductRequestDto(Long productid, String name, String description, BigDecimal price, Long categoryid, int stock) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryid = categoryid;
		this.stock = stock;

	}
	public Long getProductid() {
		return productid;
	}
	public void setProductid(Long productid) {
		this.productid = productid;
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
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	private Long productid;
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private Long categoryid;
	
	private int stock; 


}
