package com.example.ecommerce.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RoleResponseDto {
	

	private Long roleid;
	public RoleResponseDto() {
		super();
	}
	public RoleResponseDto(Long roleid, String name, String description, String rolecode, LocalDateTime createdat) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.description = description;
		this.rolecode = rolecode;
		this.createdat = createdat;
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
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	public LocalDateTime getCreatedat() {
		return createdat;
	}
	public void setCreatedat(LocalDateTime createdat) {
		this.createdat = createdat;
	}
	private String name;
	private String description;
	private String rolecode;
	@JsonFormat(pattern= "dd/mm/yyyy hh:mm a")
	private LocalDateTime createdat;

}
