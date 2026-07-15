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

	@Override
	public Page<CategoryResponseDto> getcategory(int page, int size) {
		
		Pageable pageable = PageRequest.of(page,size);
		
		Page<Category> pages = categoryrepository.findAll(pageable);
		return pages.map(category -> {
			CategoryResponseDto categoryresponsedto = new CategoryResponseDto();
			categoryresponsedto.setCategorycode(category.getCategorycode());
			categoryresponsedto.setName(category.getName());
			categoryresponsedto.setDescription(category.getDescription());
			categoryresponsedto.setCreatedat(category.getCreatedat());
		
			
			return categoryresponsedto;

		});
	
	}

	@Override
	public CategoryResponseDto getcategorybyid(Long id) {
		
		Category category = categoryrepository.findById(id).orElseThrow(() -> new RuntimeException("No Category found"));
		CategoryResponseDto categoryresponsedto = new CategoryResponseDto();
		categoryresponsedto.setCategorycode(category.getCategorycode());
		categoryresponsedto.setName(category.getName());
		categoryresponsedto.setDescription(category.getDescription());
		categoryresponsedto.setCreatedat(category.getCreatedat());
		categoryresponsedto.setUpdatedat(category.getUpdatedat());
		
		return categoryresponsedto;
	}

	@Override
	public CategoryResponseDto putcategorybyid(Long id, CategoryRequestDto categoryrequestdto) {
		
		Category category = categoryrepository.findById(id).orElseThrow(()-> new RuntimeException("No Data Found"));
		
		
		category.setName(categoryrequestdto.getName());
		category.setDescription(categoryrequestdto.getDescription());
		category.setUpdatedat(LocalDateTime.now());
		
		Category update = categoryrepository.save(category);
		
		
		CategoryResponseDto categoryresponsedto = new CategoryResponseDto();
		
		categoryresponsedto.setCategorycode(update.getCategorycode());
		categoryresponsedto.setName(update.getName());
		categoryresponsedto.setDescription(update.getDescription());
		categoryresponsedto.setUpdatedat(update.getUpdatedat());
		categoryresponsedto.setCreatedat(update.getCreatedat());
		
		return categoryresponsedto;
	}

	@Override
	public String deletecategorybyid(Long id) {
		
		Category category = categoryrepository.findById(id).orElseThrow(() -> new RuntimeException("No data found"));
		
		categoryrepository.delete(category);
		
		
		return "Deleted Sucessfully";
	}
	
	

	
	
	

	
}
