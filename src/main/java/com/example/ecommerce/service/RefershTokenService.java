package com.example.ecommerce.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.entity.RefershTokenEntity;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.RefershTokenRepository;

@Service
public class RefershTokenService {
	
	@Autowired
	private RefershTokenRepository refershtokenrepo ;
	
	@Transactional
	public RefershTokenEntity createrefershtoken(Userentity user) {
		
		refershtokenrepo.deleteByuser(user);
		refershtokenrepo.flush();

		RefershTokenEntity refreshstoken = new RefershTokenEntity();
		refreshstoken.setRefershtoken(
	                UUID.randomUUID().toString()
	        );
		refreshstoken.setExpirydate(LocalDateTime.now().plusDays(7));
		refreshstoken.setOrginalexpirydate(LocalDateTime.now().plusDays(30));
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
	        
	        if (refreshsToken.getOrginalexpirydate().isBefore(LocalDateTime.now())) {
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
