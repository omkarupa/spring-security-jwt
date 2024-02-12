package com.ou_solutions.springsecurityjwt;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.cors( cors -> cors.disable());
		http.csrf( csrf -> csrf.disable());
		
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		
		
		return http.build();
		
	}
	
}
