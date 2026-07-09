package com.example.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

public class User {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "user_id")
	private Long userid;
	
	@OneToMany
	@JoinColumn(name = "role_id")
	private Role role;
	
	private String name;
	
	@NotBlank
	private String email;
	
	

}
