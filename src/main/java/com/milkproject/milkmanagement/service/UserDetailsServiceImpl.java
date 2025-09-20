package com.milkproject.milkmanagement.service;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.milkproject.milkmanagement.exception.UserNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		if(username.equals("farmer")) {
			return new User("farmer",new BCryptPasswordEncoder().encode("milk123")
					,List.of(new SimpleGrantedAuthority("ROLE_FARMER")));
		}else if(username.equals("admin")) {
			return new User("admin",new BCryptPasswordEncoder().encode("admin123")
					,List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
		}else {
			throw new UserNotFoundException("User Not Found");
		}
	}
	
}
