package com.example.ecommerce.service.impl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.ecommerce.dto.ProductRequestDto;

public interface ProductServiceImp {

	String addproduct(ProductRequestDto productrequestdto, MultipartFile image) throws IOException;





}
