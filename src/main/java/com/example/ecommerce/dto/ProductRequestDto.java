package com.example.ecommerce.dto;

public class ProductRequestDto {
  
	public ProductRequestDto() {
		super();
	}
	public ProductRequestDto(Long productid, String name, String description, double price, Long categoryid, int stock,
			String imageurl) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.categoryid = categoryid;
		this.stock = stock;
		this.imageurl = imageurl;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	private Long productid;
	private String name;
	
	private String description;
	
	private double price;
	
	private Long categoryid;
	
	private int stock; 
	private String imageurl;

}
