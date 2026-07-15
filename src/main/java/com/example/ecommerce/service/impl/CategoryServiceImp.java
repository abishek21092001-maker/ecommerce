package com.example.ecommerce.service.impl;

import org.springframework.data.domain.Page;

import com.example.ecommerce.dto.CategoryRequestDto;
import com.example.ecommerce.dto.CategoryResponseDto;

public interface CategoryServiceImp {


	CategoryResponseDto addcategory(CategoryRequestDto categoryrequestdto);


	Page<CategoryResponseDto> getcategory(int page, int size);




	CategoryResponseDto getcategorybyid(Long id);


	CategoryResponseDto putcategorybyid(Long id, CategoryRequestDto categoryrequestdto);


	String deletecategorybyid(Long id);









}
