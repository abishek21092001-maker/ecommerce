package com.example.ecommerce.dto;

public class UserLoginResponseDTO {
	
	private String accessToken;
	public UserLoginResponseDTO() {
		super();
	}
	public UserLoginResponseDTO(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;

	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}


}
