package com.example.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dto.RefershTokenDto;
import com.example.ecommerce.dto.UserLoginRequestDTO;
import com.example.ecommerce.entity.RefershTokenEntity;
import com.example.ecommerce.entity.Userentity;
import com.example.ecommerce.repository.UserReository;
import com.example.ecommerce.service.Jwtservice;
import com.example.ecommerce.service.RefershTokenService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationmanager;

    @Autowired
    private Jwtservice jwtservice;

    @Autowired
    private UserReository userrepo;

    @Autowired
    private RefershTokenService refershtokenservice;

    public AuthController(
            AuthenticationManager authenticationmanager) {

        this.authenticationmanager = authenticationmanager;
    }

    @PostMapping("/login")
    public ResponseEntity<RefershTokenDto> login(
            @RequestBody UserLoginRequestDTO responsedto) {

        // 1. Authenticate email + password
        Authentication authentication =
                authenticationmanager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                responsedto.getEmail(),
                                responsedto.getPassword()
                        )
                );

        // 2. Generate access token
        String accesstoken =
                jwtservice.generateToken(authentication);

        // 3. Find user from database
        Userentity user =
                userrepo.findByEmail(
                        responsedto.getEmail()
                ).orElseThrow(
                        () -> new RuntimeException(
                                "Email id not found"
                        )
                );

        // 4. Create refresh token
        RefershTokenEntity refreshtoken =
                refershtokenservice.createrefershtoken(user);

        // 5. Create response
        RefershTokenDto response =
                new RefershTokenDto(
                        accesstoken,
                        refreshtoken.getRefershtoken(),
                        "Bearer"
                );

        // 6. Return both tokens
        return ResponseEntity.ok(response);
    }
}