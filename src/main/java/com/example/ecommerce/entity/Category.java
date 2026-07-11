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
	
	
	public Category() {
		super();
	}
	public Category(Long categoryid, String name, String description, LocalDateTime createdat,
			LocalDateTime updatedat) {
		super();
		this.categoryid = categoryid;
		this.name = name;
		this.description = description;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}
	public Long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getCreatedat() {
		return createdat;
	}
	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}
	public LocalDateTime getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}
	private String name;
	
	private String description;
	
	@CreatedDate
	@Column(name = "created_at", updatable = false,nullable = false)
	private LocalDateTime createdat;
	@LastModifiedDate
	@Column(name = "updated_at",nullable = false)
	private LocalDateTime updatedat;
	
	

}
