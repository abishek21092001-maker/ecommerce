package com.example.ecommerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.ProductRequestDto;
import com.example.ecommerce.service.impl.ProductServiceImp;

@RestController
@RequestMapping("api/product")
public class ProductController {
	
	private ProductServiceImp productserviceimp;
	
	@PostMapping
	public String addproduct(@RequestBody ProductRequestDto productrequestdto) {
		return productserviceimp.addproduct(productrequestdto);
	}
	
	

}
