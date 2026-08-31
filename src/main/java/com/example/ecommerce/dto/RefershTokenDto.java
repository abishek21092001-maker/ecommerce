package com.example.ecommerce.dto;





public class RefershTokenDto {
	
	 public RefershTokenDto() {
		super();
	}

	 public RefershTokenDto(String accessToken, String refreshToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.tokenType = tokenType;
	}

	 public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	 private String accessToken;

	    private String refreshToken;

	    private String tokenType;

}
