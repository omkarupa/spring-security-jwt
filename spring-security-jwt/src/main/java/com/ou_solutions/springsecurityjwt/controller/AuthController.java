package com.ou_solutions.springsecurityjwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ou_solutions.springsecurityjwt.mapper.UserRegisterationDTO;
import com.ou_solutions.springsecurityjwt.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
	
	private final AuthService authService;
	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "Welcome to Spring Security with JWT Authentication";
	}
	
	@PostMapping("/users/sign-up")
	public ResponseEntity<?> registerUser(@RequestBody  UserRegisterationDTO userReg) throws Exception
	{
		
		return ResponseEntity.ok(authService.registerUser(userReg));

		
	}
	
	
	

}
