package com.example.ecommerce.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
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
	
	public String extractEmail(String token) {
		
		return extractClaim(token,Claims::getSubject);
	}
	
	public <T> T extractClaim(String token , Function<Claims,T> claimsResolver) {
		
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {

	    return Jwts
	            .parser()
	            .verifyWith((SecretKey) getsignkey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();

	}

	
	
	private Key getsignkey() {
		// TODO Auto-generated method stub
		return Keys.hmacShaKeyFor(Secrect_key.getBytes(StandardCharsets.UTF_8));
	}
	
	
	
	
	
	

}
