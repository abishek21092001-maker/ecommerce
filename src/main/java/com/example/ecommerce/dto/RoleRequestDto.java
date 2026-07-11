package com.example.ecommerce.dto;

public class RoleRequestDto {
	private String name;
	public RoleRequestDto() {
		super();
	}
	public RoleRequestDto(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	private String description;

}
