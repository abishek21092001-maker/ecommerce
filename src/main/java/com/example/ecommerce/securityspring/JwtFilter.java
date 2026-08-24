package com.example.ecommerce.securityspring;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ecommerce.service.CustomUserDetailsService;
import com.example.ecommerce.service.Jwtservice;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	public final CustomUserDetailsService userdetailss;
	public final Jwtservice jwtservice;
	public JwtFilter(CustomUserDetailsService userdetailss,Jwtservice jwtservice) {
		this.userdetailss = userdetailss;
		this.jwtservice = jwtservice;
		
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String authheader = request.getHeader("Authorization");
		
		if(authheader == null || authheader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
			
		}
		
		String token = authheader.substring(7);
		String username = jwtservice.extractUsername(token);
		
		if(username!=null) {
			UserDetails userdetails = userdetailss.loadUserByUsername(username);

		
		if(jwtservice.isValid(token,userdetails )) {
			

            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                    		userdetails,
                            null,
                            userdetails.getAuthorities()
                    );
            SecurityContextHolder
            .getContext()
            .setAuthentication(authentication);
		}
		}
		
		filterChain.doFilter(request, response);
	}

}
