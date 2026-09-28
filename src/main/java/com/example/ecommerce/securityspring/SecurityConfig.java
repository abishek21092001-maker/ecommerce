package com.example.ecommerce.securityspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.example.ecommerce.controller.AuthController;
import com.example.ecommerce.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	private final JwtFilter jwtFilter;
	private final CustomAuthenticaltionEntrypoint cstomentrypoint;
	private final CustomAcessdeniedEntrypoint customacessdenired;

    public SecurityConfig(JwtFilter jwtFilter,

    		CustomAuthenticaltionEntrypoint cstomentrypoint,
    		CustomAcessdeniedEntrypoint customacessdenired) {
        this.jwtFilter = jwtFilter;

        this.cstomentrypoint = cstomentrypoint;
        this.customacessdenired =customacessdenired;
    }
	
	@Bean
	public PasswordEncoder passwordencoder() {
		
		return new BCryptPasswordEncoder();
	}
	

	@Bean
	public AuthenticationProvider authenticationprovider(CustomUserDetailsService cudservice,PasswordEncoder passwordencoder) {
		
		DaoAuthenticationProvider daoauthenticationprovider = new DaoAuthenticationProvider(cudservice);
		daoauthenticationprovider.setPasswordEncoder(passwordencoder);
		return daoauthenticationprovider;
	}
	
	@Bean
	public AuthenticationManager authenticationmanager(AuthenticationConfiguration authenticationconfig) throws Exception{
		return authenticationconfig.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    http
	        .csrf(csrf -> csrf.disable())

	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/api/auth/login").permitAll()
	            .requestMatchers("/api/category").hasRole("Admin")
	            .requestMatchers("/api/cart").hasRole("User")
	            .anyRequest().authenticated()
	        )
	        .exceptionHandling(exception -> exception.authenticationEntryPoint(cstomentrypoint)
	        		.accessDeniedHandler(customacessdenired))

	        .addFilterBefore(
	            jwtFilter,
	            UsernamePasswordAuthenticationFilter.class
	        );

	    return http.build();
	}
	

}
