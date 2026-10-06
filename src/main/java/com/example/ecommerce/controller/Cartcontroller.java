package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.CartRequestDto;
import com.example.ecommerce.service.impl.CartServiceImp;

@RestController
@RequestMapping("/api/cart")
public class Cartcontroller {
	
	@Autowired
	private CartServiceImp cartimp;
	
	@PostMapping
	public ResponseEntity addcart(@RequestBody CartRequestDto cartrequestdto ) {
		cartimp.addcart(cartrequestdto);
		 
		 return ResponseEntity.status(HttpStatus.CREATED).body("created");

}
	public ResponseEntity updatecart(@PathVariable Long id,@RequestBody CartRequestDto cartrequestdto) {
		cartimp.updatebyid(id,cartrequestdto);
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body("updated");
		
		
		
	}
	

}
