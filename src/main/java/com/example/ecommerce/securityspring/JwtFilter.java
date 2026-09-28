package com.example.ecommerce.securityspring;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.ecommerce.service.Jwtservice;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final Jwtservice jwtservice;

    public JwtFilter(Jwtservice jwtservice) {
        this.jwtservice = jwtservice;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        // 1. Get Authorization header
        String authheader =
                request.getHeader("Authorization");

  

        // 2. Check Bearer token
        if (authheader == null ||
                !authheader.startsWith("Bearer ")) {

            filterChain.doFilter(request, response);
            return;
        }

        // 3. Extract JWT
        String token = authheader.substring(7);

        try {

            // 4. Extract email from JWT
            String username =
                    jwtservice.extractUsername(token);

            // 5. Extract role from JWT
            String role =
                    jwtservice.extractRole(token);

//            System.out.println("Username: " + username);
//            System.out.println("Role: " + role);

            // 6. Check if user is not already authenticated
            if (username != null &&
                    SecurityContextHolder
                            .getContext()
                            .getAuthentication() == null) {

                // 7. Check token validity
                if (!jwtservice.isTokenExpired(token)) {

                    // 8. Convert role into Spring Security authority
                    SimpleGrantedAuthority authority =
                            new SimpleGrantedAuthority(role);

                    // 9. Create authenticated user
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    username,
                                    null,
                                    List.of(authority)
                            );

                    // 10. Store authentication
                    SecurityContextHolder
                            .getContext()
                            .setAuthentication(authentication);
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Invalid JWT: " + e.getMessage()
            );
        }

        // 11. Continue request
        filterChain.doFilter(request, response);
    }
}