package com.example.ecommerce.dto;

import java.time.LocalDateTime;

public class CategoryRequestDto {
	

private String categorycode;
public CategoryRequestDto() {
	super();
}
public CategoryRequestDto(String categorycode, String name, String description, LocalDateTime createdat,
		LocalDateTime updatedat) {
	super();
	this.categorycode = categorycode;
	this.name = name;
	this.description = description;
	this.createdat = createdat;
	this.updatedat = updatedat;
}
public String getCategorycode() {
	return categorycode;
}
public void setCategorycode(String categorycode) {
	this.categorycode = categorycode;
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
private String name;
private String description;
private LocalDateTime createdat;
private LocalDateTime updatedat;

}
