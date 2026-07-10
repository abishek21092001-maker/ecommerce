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
