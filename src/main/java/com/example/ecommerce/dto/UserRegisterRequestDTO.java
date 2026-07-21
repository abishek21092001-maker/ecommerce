package com.example.ecommerce.dto;

public class UserRegisterRequestDTO {

	public UserRegisterRequestDTO() {
		super();
	}
	public UserRegisterRequestDTO(String name, String rolecode, Long roleid, String email, String password,
			String phone, String address) {
		super();
		this.name = name;
		this.rolecode = rolecode;
		this.roleid = roleid;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRolecode() {
		return rolecode;
	}
	public void setRolecode(String rolecode) {
		this.rolecode = rolecode;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
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
	private String name;
	private String rolecode;
	private Long roleid;
	private String email;
	private String password;
	private String phone;
	private String address;
}
