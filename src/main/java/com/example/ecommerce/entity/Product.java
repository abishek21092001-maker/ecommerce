package com.example.ecommerce.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	public Product() {
		super();
	}

	public Product(Long productid, Category categoryid, String name, String description, double price, int stock,
			String imageurl, LocalDateTime createdat, LocalDateTime updatedat) {
		super();
		this.productid = productid;
		this.categoryid = categoryid;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.imageurl = imageurl;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public Category getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Category categoryid) {
		this.categoryid = categoryid;
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

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productid;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category categoryid;
	
	private String name;
	
	private String description;
	
	private double price;
	
	private int stock; 
	
	@Column(name = "image_url")
	private String imageurl;
	
	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdat;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updatedat;
	 
	
	

}
