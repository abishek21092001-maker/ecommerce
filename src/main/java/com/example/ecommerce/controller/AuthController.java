package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.UserLoginRequestDTO;
import com.example.ecommerce.service.Jwtservice;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final AuthenticationManager authenticationmanager;
	
	@Autowired
	private Jwtservice jwtservice;
	
	public AuthController(AuthenticationManager authenticationmanager) {
		this.authenticationmanager = authenticationmanager;
	}
	@PostMapping("/login")
	public ResponseEntity<String>login(@RequestBody UserLoginRequestDTO responsedto){
		
		Authentication authentication = authenticationmanager.authenticate(
				new UsernamePasswordAuthenticationToken(
						responsedto.getEmail(),
						responsedto.getPassword()));
			String s = 	jwtservice.generateToken(authentication);
		
		return ResponseEntity.ok(s);
		
	}

}
