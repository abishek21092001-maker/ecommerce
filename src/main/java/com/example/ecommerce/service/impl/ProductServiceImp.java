package com.example.ecommerce.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.ProductRequestDto;
import com.example.ecommerce.dto.ProductResponseDto;

public interface ProductServiceImp {

	String addproduct(ProductRequestDto productrequestdto, MultipartFile image) throws IOException;

	Page<ProductResponseDto> getproduct(int page, int size);

	List<ProductResponseDto> searchproduct(String name);

	List<ProductResponseDto> filterbyrange(Double min, Double max);

	ProductResponseDto getproductbyid(Long id);

	String updateproductbyid(Long id, ProductRequestDto productrequestdto);

	





}
