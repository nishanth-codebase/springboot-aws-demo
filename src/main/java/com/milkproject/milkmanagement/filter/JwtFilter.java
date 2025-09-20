package com.milkproject.milkmanagement.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.milkproject.milkmanagement.service.UserDetailsServiceImpl;
import com.milkproject.milkmanagement.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	@Autowired
	JwtUtil jwtutil;
	
	@Autowired
	UserDetailsServiceImpl userdetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String header=request.getHeader("Authorization");
		String token=null;
		String username=null;
		if(header!=null && header.startsWith("Bearer ")) {
			System.out.println("check toeken:"+header);
			token=header.substring(7);
			System.out.println("check toeken sub:"+token);
			try {
				username=jwtutil.getUserName(token);
				System.out.println("check username"+username);
			}catch(Exception e) {
				System.out.println("Invalid Token");
			}
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
			UserDetails userdetails=userdetailsService.loadUserByUsername(username);
			if(jwtutil.validateToken(token)) {
				UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
						userdetails,null,userdetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	

}
