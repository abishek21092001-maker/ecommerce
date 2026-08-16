package com.example.ecommerce.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class Jwtservice {
	
	@Value("${jwt.secret}")
	private  String Secrect_key ;

	
	
	

}
