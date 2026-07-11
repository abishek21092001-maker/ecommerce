package com.example.ecommerce.dto;

public class RoleResponseDto {
	
	public RoleResponseDto() {
		super();
	}
	public RoleResponseDto(Long roleid, String name, String description) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.description = description;
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
	private Long roleid;
	private String name;
	private String description;

}
