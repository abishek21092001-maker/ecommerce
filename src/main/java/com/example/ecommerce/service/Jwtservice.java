package com.example.ecommerce.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class Jwtservice {
	
	@Value("${jwt.secret}")
	private  String Secrect_key ;
	
	public String generatetoken(String email) {
		
		return Jwts.builder()
				.subject(email)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 10000 * 60 * 60 ))
				.signWith(getsignkey())
				.compact();
		
		
	}

	private Key getsignkey() {
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(Secrect_key.getBytes(StandardCharsets.UTF_8));
	}
	
	
	

}
