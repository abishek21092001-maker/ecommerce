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
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "user_id")
	private Long userid;
	
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	private String name;
	
	@NotBlank
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(unique = true)
	private String phone;
	
	private String address;
	
	@CreatedDate
	@Column(name = "created_at",nullable = false)
	private LocalDateTime createdat;
	
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false)
	private LocalDateTime updateddat;
	
	
	

}
