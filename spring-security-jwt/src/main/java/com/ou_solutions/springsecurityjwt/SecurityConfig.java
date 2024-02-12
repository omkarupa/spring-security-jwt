package com.ou_solutions.springsecurityjwt;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.websocket.Session;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.cors( cors -> cors.disable());
		http.csrf( csrf -> csrf.disable());
		
		http.authorizeHttpRequests(
				(requests) -> requests
				.requestMatchers(new AntPathRequestMatcher("/api/users/sign-up/**")).permitAll()
				.anyRequest().authenticated());
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		
		
		return http.build();
		
	}
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
	
}
