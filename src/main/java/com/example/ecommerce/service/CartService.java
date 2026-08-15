package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartRequestDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserReository;
import com.example.ecommerce.service.impl.CartServiceImp;
@Service
public class CartService implements CartServiceImp{
	
	@Autowired
	private UserReository userrepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private CartRepository cartrepo;
	


	@Override
	public String addcart(CartRequestDto cartrequestdto) {
		
		
		Userentity user = userrepo.findById(cartrequestdto.getUserid()).orElseThrow(() -> new RuntimeException("User Not Found"));
		
		
		
		Product product = productrepo.findById(cartrequestdto.getProductid()).orElseThrow(() -> new RuntimeException("product Not Found"));
		
		
	
		
		
		
		
		
		
		
			
		
		
		return null;
	}

}
