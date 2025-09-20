package com.milkproject.milkmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.milkproject.milkmanagement.DTOs.AuthRequest;
import com.milkproject.milkmanagement.DTOs.AuthResponse;
import com.milkproject.milkmanagement.util.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	private JwtUtil jwtutil;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest){
		try {
			Authentication authentication=authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
			String token=jwtutil.generateToken(authRequest.getUsername(), 
					authentication.getAuthorities().iterator().next().getAuthority());
			return ResponseEntity.ok(new AuthResponse(token));
		}catch(AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
		}
	}

}
