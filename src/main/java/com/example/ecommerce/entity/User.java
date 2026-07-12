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
	
	
	public User() {
		super();
	}

	public User(Long userid, Role role, String name, @NotBlank String email, String password, String phone,
			String address, LocalDateTime createdat, LocalDateTime updateddat) {
		super();
		this.userid = userid;
		this.role = role;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.createdat = createdat;
		this.updateddat = updateddat;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreatedat() {
		return createdat;
	}

	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}

	public LocalDateTime getUpdateddat() {
		return updateddat;
	}

	public void setUpdateddat(LocalDateTime updateddat) {
		this.updateddat = updateddat;
	}

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
	@Column(name = "created_at",nullable = false,updatable = false)
	private LocalDateTime createdat;
	
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false)
	private LocalDateTime updateddat;
	
	
	

}
