package com.example.ecommerce.service;

import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CategoryRequestDto;
import com.example.ecommerce.dto.CategoryResponseDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.impl.CategoryServiceImp;

@Service
public class CategoryService implements CategoryServiceImp {
	private CategoryRepository categoryrepository ;

	@Override
	public CategoryResponseDto addcategory(CategoryRequestDto categoryrequestdto) {
		
		// TODO Auto-generated method stub
		return null;
	}
	

}
