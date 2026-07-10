package com.example.ecommerce.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartid;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@CreatedDate
	@Column(name = "created_at")
	private String createdat;
	
	@LastModifiedDate
	@Column(name = "updated_at")
	private String updatedat;
	
	
	
	
	
	
	
	
	

}
