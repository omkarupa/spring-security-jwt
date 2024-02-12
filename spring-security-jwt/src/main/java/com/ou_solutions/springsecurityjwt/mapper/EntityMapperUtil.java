package com.ou_solutions.springsecurityjwt.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.ou_solutions.springsecurityjwt.entity.User;
import com.ou_solutions.springsecurityjwt.mapper.UserRegisterationDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EntityMapperUtil {
	
	private final PasswordEncoder encoder;
	
	public User convertMapIntoEntity(UserRegisterationDTO userReg)
	{
		User user = new User();
		user.setEmailId(userReg.emailId());
		user.setName(userReg.name());
		user.setPassword(encoder.encode(userReg.password()));
		user.setRoles(userReg.role());
		
		return user;
	}

}
