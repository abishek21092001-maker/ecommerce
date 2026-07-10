package com.example.ecommerce.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Long categoryid ;
	
	
	private String name;
	
	private String description;
	
	@CreatedDate
	@Column(name = "created_at", updatable = false,nullable = false)
	private LocalDateTime createdat;
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false)
	private LocalDateTime updatedat;
	
	

}
