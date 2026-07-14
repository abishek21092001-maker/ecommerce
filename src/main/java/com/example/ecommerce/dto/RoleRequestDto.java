package com.example.ecommerce.dto;

import java.time.LocalDateTime;

public class RoleRequestDto {
	public RoleRequestDto() {
		super();
	}
	public RoleRequestDto(String name, String description, LocalDateTime updatedat) {
		super();
		this.name = name;
		this.description = description;
		this.updatedat = updatedat;
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
	public LocalDateTime getUpdatedat() {
		return updatedat;
	}
	public void setUpdatedat(LocalDateTime updatedat) {
		this.updatedat = updatedat;
	}
	private String name;
	private String description;
	private LocalDateTime updatedat;

}
