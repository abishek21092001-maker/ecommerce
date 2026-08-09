package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CartItemRequestDto;
import com.example.ecommerce.service.impl.CartServiceImp;

@RestController
@RequestMapping("/api/cart")
public class Cartcontroller {
	
	@Autowired
	private CartServiceImp cartimp;
	
	@PostMapping
	public String addcart(@RequestBody CartItemRequestDto cartitemrequestdto ) {
		return cartimp.addcart(cartitemrequestdto);
	}

}
