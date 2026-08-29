package com.example.ecommerce.service;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


	
@Service
public class Jwtservice {
	
	@Value("${jwt.secret}")
	private  String Secrect_key ;
	// create the Jwt token
	public String generateToken(Authentication authentication) {
		
		String email = authentication.getName();
		
		String role = authentication.getAuthorities()
				.stream()
				.findFirst()
				.get()
				.getAuthority();
		
		return Jwts.builder()
				.subject(email)
				.claim("role", role)
				.issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis() + 1000 *60 * 30))
				.signWith(getsecrectkey())
				.compact();
	}
    // create the secrect key  which should undertand by the computer
	private SecretKey getsecrectkey() {
		// TODO Auto-generated method stub	
		return Keys.hmacShaKeyFor(Secrect_key.getBytes(StandardCharsets.UTF_8));
	}
	// 
	public String extractUsername(String token) {
		return Jwts.parser()
				.verifyWith(getsecrectkey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getSubject();
	}
	
	public Boolean isValid(String token , UserDetails userdetails) {
		
		String Username = extractUsername(token);
		
		return Username.equals(userdetails.getUsername() ) && !isTokenExpired(token);
	}

	public boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		Date Expiration = Jwts.parser()
				.verifyWith(getsecrectkey())
				.build()
				.parseSignedClaims(token)
				.getPayload()
				.getExpiration();
		return Expiration.before(new Date());
	}
	
	
	public String extractRole(String token) {

	    return Jwts.parser()
	            .verifyWith(getsecrectkey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload()
	            .get("role", String.class);
	}
	
	
	
	
	
	

	
	
	

}
