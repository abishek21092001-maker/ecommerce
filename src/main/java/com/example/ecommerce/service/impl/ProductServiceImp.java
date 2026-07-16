package com.example.ecommerce.service.impl;

import java.io.IOException;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.ProductRequestDto;
import com.example.ecommerce.dto.ProductResponseDto;

public interface ProductServiceImp {

	String addproduct(ProductRequestDto productrequestdto, MultipartFile image) throws IOException;

	Page<ProductResponseDto> getproduct(int page, int size);





}
