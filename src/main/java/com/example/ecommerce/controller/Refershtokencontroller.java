package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.RefershTokenDto;
import com.example.ecommerce.dto.refereshtokenresponsedto;
import com.example.ecommerce.entity.RefershTokenEntity;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.RefershTokenRepository;
import com.example.ecommerce.service.CustomUserDetailsService;
import com.example.ecommerce.service.Jwtservice;
import com.example.ecommerce.service.RefershTokenService;

@RestController
@RequestMapping("/api/refershtoken")
public class Refershtokencontroller {
	
	@Autowired
	private RefershTokenRepository refershtoken;
	@Autowired
	private RefershTokenService refershtokenservice;
	@Autowired
	private Jwtservice jwtservice;
	@Autowired
	private CustomUserDetailsService su;
	
	@PostMapping
	public ResponseEntity<?> addrefershtoken(@RequestBody RefershTokenDto response){
		
		String token = response.getRefreshToken();
		
		RefershTokenEntity refreshtokenentity =refershtoken.findByrefershtoken(token).orElseThrow(() -> new RuntimeException("No resfresh token found"));
		refershtokenservice.verifyExpiration(refreshtokenentity);
		System.out.println(refreshtokenentity + " working");
		Userentity  user = refreshtokenentity.getUser();
	
		RefershTokenEntity t = refershtokenservice.createrefershtoken(user);
		String tokzen = t.getRefershtoken();
		UserDetails userDetails = su.loadUserByUsername(user.getEmail());
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
		
		String acesstoken = jwtservice.generateToken(authentication);
		
		refereshtokenresponsedto ref = new refereshtokenresponsedto(tokzen,acesstoken,"Bearer");
		
		return ResponseEntity.ok(ref);
		
	}
	
	

}
