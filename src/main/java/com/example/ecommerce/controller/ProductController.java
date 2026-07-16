package com.example.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.ProductRequestDto;
import com.example.ecommerce.dto.ProductResponseDto;
import com.example.ecommerce.service.impl.ProductServiceImp;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	private ProductServiceImp productserviceimp;
	
	@PostMapping
	public String addproduct(@ModelAttribute ProductRequestDto productrequestdto, @RequestParam MultipartFile image) throws IOException{
		return productserviceimp.addproduct(productrequestdto,image);
	}
	
	
	@GetMapping
	public Page<ProductResponseDto> getproduct(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size){
		
        return productserviceimp.getproduct(page,size);
		
	}
	
	
	public ProductResponseDto getproductbyid() {
		return null;
	}
	

}
