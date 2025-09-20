package com.milkproject.milkmanagement.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	//private static final String secret="milkprojectsecretnishanthJuvva8106990677";
	private static final String secret="G5vcfU9YgOQzM9FVRgfj+e0YdHLpNl5RYNgHf+l2Uo8=";
	
	public String generateToken(String username,String role) {
		return Jwts
				.builder()
				.setSubject(username)
				.claim("role", role)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(SignatureAlgorithm.HS256, secret)
				.compact();
	}
	
	public boolean validateToken(String token) {
		try {
	        Jwts.parserBuilder()
	            .setSigningKey(secret)  // Use the correct key method
	            .build()
	            .parseClaimsJws(token); // ✅ Use parseClaimsJws, not parseClaimsJwt
	        return true;
	    } catch (JwtException e) {
	        System.out.println("Invalid JWT: " + e.getMessage());
	        return false;
	    }
	}
	
	public String getUserName(String token) {
		return Jwts.parserBuilder()
	               .setSigningKey(secret)
	               .build()
	               .parseClaimsJws(token)
	               .getBody()
	               .getSubject();
	}
	
	public String getRole(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(secret)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.get("role",String.class);
	}

}
