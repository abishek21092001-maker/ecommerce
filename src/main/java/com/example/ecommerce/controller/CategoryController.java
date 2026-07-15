package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@GetMapping
	public Page<CategoryResponseDto> getcategory(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "2") int size){
		
		return categoryserviceimp.getcategory(page,size);
	}
	
	@GetMapping("/{id}")
	public CategoryResponseDto getcategorybyid(@PathVariable Long id) {
		return categoryserviceimp.getcategorybyid(id);
	}
	
	
	@PutMapping("/{id}")
	public CategoryResponseDto putcategorybyid(@PathVariable Long id, @RequestBody CategoryRequestDto categoryrequestdto) {
		return categoryserviceimp.putcategorybyid(id,categoryrequestdto);
	}
	
	@DeleteMapping("/{id}")
	public String deletecategorybyid(@PathVariable Long id) {
		
		return categoryserviceimp.deletecategorybyid(id);
		
	}
	
	
	
	
	
	 

}
