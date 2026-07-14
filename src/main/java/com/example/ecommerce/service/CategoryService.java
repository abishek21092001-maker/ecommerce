package com.example.ecommerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CategoryRequestDto;
import com.example.ecommerce.dto.CategoryResponseDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.impl.CategoryServiceImp;

@Service
public class CategoryService implements CategoryServiceImp {
	
	@Autowired
	private CategoryRepository categoryrepository ;

	@Override
	public CategoryResponseDto addcategory(CategoryRequestDto categoryrequestdto) {
		
		
		Category category = new Category();
		
		category.setName(categoryrequestdto.getName());
		category.setDescription(categoryrequestdto.getDescription());
		category.setUpdatedat(LocalDateTime.now());
		category.setCreatedat(LocalDateTime.now());
		Category saved = categoryrepository.save(category);
		String code = String.format("C_" + "%03d", saved.getCategoryid());
		category.setCategorycode(code);
		
		saved = categoryrepository.save(saved);
		
		
		
		CategoryResponseDto categoryresponsedto = new CategoryResponseDto();
		
		categoryresponsedto.setCategorycode(saved.getCategorycode());
		categoryresponsedto.setName(saved.getName());
		categoryresponsedto.setDescription(saved.getDescription());
		categoryresponsedto.setCreatedat(saved.getCreatedat());
		categoryresponsedto.setUpdatedat(saved.getUpdatedat());

		return categoryresponsedto;
	}

	



	
	

}
