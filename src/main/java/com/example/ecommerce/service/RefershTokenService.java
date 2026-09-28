package com.example.ecommerce.service;

import java.time.LocalDateTime;
import java.util.UUID;

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

		RefershTokenEntity refreshstoken = new RefershTokenEntity();
		refreshstoken.setRefershtoken(
	                UUID.randomUUID().toString()
	        );
		refreshstoken.setExpirydate(LocalDateTime.now().plusDays(7));
		refreshstoken.setUser(user);
		return refershtokenrepo.save(refreshstoken);

	}
		
		public RefershTokenEntity verifyExpiration(RefershTokenEntity refreshsToken) {

	        if (refreshsToken.getExpirydate()
	                .isBefore(LocalDateTime.now())) {

	        	refershtokenrepo.delete(refreshsToken);

	            throw new RuntimeException(
	                    "Refresh token expired"
	            );
	        }
	        
	        if (refreshsToken.getOrginalexpirydate().isAfter(LocalDateTime.now())) {
	        	refershtokenrepo.delete(refreshsToken);

	            throw new RuntimeException(
	                    "Refresh token expired"
	            );
	        	
	        }
	        

	        return refreshsToken;
	    
		
	}
		

		public void deletebyuser(Userentity userentity) {
			// TODO Auto-generated method stub
			RefershTokenEntity refreshstoken = refershtokenrepo.findByuser(userentity).orElseThrow(() -> new RuntimeException(""));
			refershtokenrepo.delete(refreshstoken);
			
			
			
		}

		

}
