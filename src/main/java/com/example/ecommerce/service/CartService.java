package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dto.CartItemRequestDto;
import com.example.ecommerce.entity.CartItem;
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
	
	@Autowired
	private CartItem cartitem;

	@Override
	public String addcart(CartItemRequestDto cartitemrequestdto) {
		
		return null;
	}

}
