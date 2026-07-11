package com.example.ecommerce.dto;

public class CategoryResponseDto {

private Long categoryid ;
public CategoryResponseDto() {
	super();
}

public CategoryResponseDto(Long categoryid, String name, String description) {
	super();
	this.categoryid = categoryid;
	this.name = name;
	this.description = description;
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

private String name;
	
private String description;
	

}
