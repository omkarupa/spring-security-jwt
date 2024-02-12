package com.ou_solutions.springsecurityjwt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ou_solutions.springsecurityjwt.entity.User;
import com.ou_solutions.springsecurityjwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetail implements UserDetailsService {
	
	
	
	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user =  userRepository.findByEmailId(username).orElseThrow(null);
		
		if(user == null)
		{
			new UsernameNotFoundException("User not exists by Username");
		}
		
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getRoles()));
		
		org.springframework.security.core.userdetails.User userDetails = buildUserForAuthentication(user, authorities);
		
		return userDetails;
	}
	
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, Collection<GrantedAuthority> authorities) {
	    //accountNonExpired, credentialsNonExpired, accountNonLocked, authorities properties
	    System.out.println("called buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) method....");
	    return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), true, true, true, true, authorities);
	}

}
