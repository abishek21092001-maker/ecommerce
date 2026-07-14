package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CategoryRequestDto;
import com.example.ecommerce.dto.CategoryResponseDto;
import com.example.ecommerce.service.impl.CategoryServiceImp;
 
@RestController
@RequestMapping("api/category")
public class CategoryController {
	
	@Autowired
	private  CategoryServiceImp categoryserviceimp;
	
	@PostMapping
	public CategoryResponseDto addcategory(@RequestBody CategoryRequestDto categoryrequestdto ) {
		
		return categoryserviceimp.addcategory(categoryrequestdto);
	}
	
	
	 

}
