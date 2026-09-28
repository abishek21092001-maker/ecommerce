package com.example.ecommerce.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.entity.RefershTokenEntity;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.RefershTokenRepository;

@Service
public class RefershTokenService {
	
	@Autowired
	private RefershTokenRepository refershtokenrepo ;
	
	public RefershTokenEntity createrefershtoken(Userentity user) {
		
		refershtokenrepo.deleteByuser(user);
		refershtokenrepo.flush();
		RefershTokenEntity refreshtoken = new RefershTokenEntity();
		refreshtoken.setExpirydate(LocalDateTime.now().plusDays(7));
		refreshtoken.setUser(user);
		return refershtokenrepo.save(refreshtoken);
	}
		
		public RefershTokenEntity verifyExpiration(RefershTokenEntity refreshToken) {

	        if (refreshToken.getExpirydate()
	                .isBefore(LocalDateTime.now())) {

	        	refershtokenrepo.delete(refreshToken);

	            throw new RuntimeException(
	                    "Refresh token expired"
	            );
	        }

	        return refreshToken;
	    
		
	}
		

}
