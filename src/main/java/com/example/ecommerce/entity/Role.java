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
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="role_id")
	private Long roleid;
	
	@Column(name ="role_name")
	private String name;
	
	private String description;
	@CreatedDate
	@Column(name ="created_at")
	private LocalDateTime createdat;
	
	@LastModifiedDate
	@Column(name ="updated_at")
	private LocalDateTime updatedat;

}
