package com.example.ecommerce.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class CartItem {
	
		private Long cartitemid;
		
		@OneToMany
		@JoinColumn(name = "cart_id")
		private Cart cart;
		
		

}
