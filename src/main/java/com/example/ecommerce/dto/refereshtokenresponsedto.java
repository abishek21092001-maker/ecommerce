package com.example.ecommerce.dto;

public class refereshtokenresponsedto {
	
	public refereshtokenresponsedto() {
		super();
	}
	public String getRefershtoken() {
		return refershtoken;
	}
	public void setRefershtoken(String refershtoken) {
		this.refershtoken = refershtoken;
	}
	public String getAcesstoken() {
		return acesstoken;
	}
	public void setAcesstoken(String acesstoken) {
		this.acesstoken = acesstoken;
	}
	public String getTokentype() {
		return tokentype;
	}
	public void setTokentype(String tokentype) {
		this.tokentype = tokentype;
	}
	public refereshtokenresponsedto(String refershtoken, String acesstoken, String tokentype) {
		super();
		this.refershtoken = refershtoken;
		this.acesstoken = acesstoken;
		this.tokentype = tokentype;
	}
	private String refershtoken;
	private String acesstoken;
	private String tokentype;

}
