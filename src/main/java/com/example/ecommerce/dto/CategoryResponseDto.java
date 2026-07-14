package com.example.ecommerce.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CategoryResponseDto {


private String categorycode;
public CategoryResponseDto() {
	super();
}
public CategoryResponseDto(String categorycode, String name, String description, LocalDateTime updatedat,
		LocalDateTime createdat) {
	super();
	this.categorycode = categorycode;
	this.name = name;
	this.description = description;
	this.updatedat = updatedat;
	this.createdat = createdat;
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
public LocalDateTime getUpdatedat() {
	return updatedat;
}
public void setUpdatedat(LocalDateTime updatedat) {
	this.updatedat = updatedat;
}
public LocalDateTime getCreatedat() {
	return createdat;
}
public void setCreatedat(LocalDateTime createdat) {
	this.createdat = createdat;
}
private String name;
private String description;
@JsonFormat(pattern = "dd/mm/yyyy hh:mm a")
private LocalDateTime updatedat;
@JsonFormat(pattern = "dd/mm/yyyy hh:mm a")
private LocalDateTime createdat;
	

}
