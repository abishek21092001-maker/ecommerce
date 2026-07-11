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
	
	public Cart() {
		super();
	}

	public Cart(Long cartid, User user, String createdat, String updatedat) {
		super();
		this.cartid = cartid;
		this.user = user;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCreatedat() {
		return createdat;
	}

	public void setCreatedat(String createdat) {
		this.createdat = createdat;
	}

	public String getUpdatedat() {
		return updatedat;
	}

	public void setUpdatedat(String updatedat) {
		this.updatedat = updatedat;
	}

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
