package com.example.ecommerce.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="role_id")
	private Long id;
	
	@Column(name ="role_name")
	private String name;
	
	private String description;
	@Column(name ="created_at")
	private LocalDateTime createdat;
	@Column(name ="updated_at")
	private LocalDateTime updatedat;

}
