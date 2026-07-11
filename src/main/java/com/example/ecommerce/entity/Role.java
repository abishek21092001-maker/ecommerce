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
	
	public Role() {
		super();
	}

	public Role(Long roleid, String name, String description, LocalDateTime createdat, LocalDateTime updatedat) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.description = description;
		this.createdat = createdat;
		this.updatedat = updatedat;
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
