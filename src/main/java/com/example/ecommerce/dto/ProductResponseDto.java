package com.example.ecommerce.dto;

public class ProductResponseDto {
	
	private String product_id;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	 public ProductResponseDto() {
		super();
	}
	 public ProductResponseDto(String product_id, String name, String description, double price, int stock,
			String imageurl) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageurl = imageurl;
	}
	 private String name;
		
		private String description;
		
		private double price;
		
		private int stock; 
		private String imageurl;

}
