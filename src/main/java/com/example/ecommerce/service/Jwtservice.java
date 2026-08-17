package com.example.ecommerce.service;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;



@Service
public class Jwtservice {
	
	@Value("${jwt.secret}")
	private  String Secrect_key ;
	
	public String generateToken(UserDetails userdetails) {
		return Jwts.builder()
				.subject(userdetails.getUsername())
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 *60 * 30))
				.signWith(getsecrectkey())
				.compact();
	}

	private Key getsecrectkey() {
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(Secrect_key.getBytes(StandardCharsets.UTF_8));
	}
	
	
	

	
	
	

}
