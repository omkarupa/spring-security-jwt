package com.ou_solutions.springsecurityjwt.repository;

import org.springframework.stereotype.Component;

import com.ou_solutions.springsecurityjwt.entity.User;
import com.ou_solutions.springsecurityjwt.mapper.UserRegisterationDTO;

@Component
public class EntityMapperUtil {
	
	public User convertMapIntoEntity(UserRegisterationDTO userReg)
	{
		User user = new User();
		user.setEmailId(userReg.emailId());
		user.setName(userReg.name());
		user.setPassword("{noop}" + userReg.password());
		user.setRoles(userReg.role());
		
		return user;
	}

}
