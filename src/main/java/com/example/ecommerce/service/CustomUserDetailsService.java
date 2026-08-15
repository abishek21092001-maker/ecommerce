package com.example.ecommerce.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.UserReository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	
	private final UserReository userrepo;
	
	private CustomUserDetailsService( UserReository userrepo) {
		this.userrepo = userrepo;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Userentity user1 = userrepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No Email id found"));
		// TODO Auto-generated method stub
		return User.builder()
				.username(user1.getEmail())
				.password(user1.getPassword())
				.roles(user1.getRole().getName())
				.build();
	}

}
