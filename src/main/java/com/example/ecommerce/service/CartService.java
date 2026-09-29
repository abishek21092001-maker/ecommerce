package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartRequestDto;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserReository;
import com.example.ecommerce.service.impl.CartServiceImp;
@Service
public class CartService implements CartServiceImp{
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private CartRepository cartrepo;
	
	@Autowired
	private UserReository uspero;

	@Override
	public CartRequestDto addcart(CartRequestDto cartrequestdto) {
		

		
		
		
		
		
		
		
		
		return null;
	}
	


}
