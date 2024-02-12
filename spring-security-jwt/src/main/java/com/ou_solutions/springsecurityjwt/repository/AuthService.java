package com.ou_solutions.springsecurityjwt.repository;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.stereotype.Service;

import com.ou_solutions.springsecurityjwt.entity.User;
import com.ou_solutions.springsecurityjwt.mapper.UserRegisterationDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
	
	private final UserRepository userRepository;
	private final EntityMapperUtil util;
	
	public UserRegisterationDTO registerUser(UserRegisterationDTO userReg) throws Exception
	{
		
		try {
			User user = util.convertMapIntoEntity(userReg);
			
			if(!userRepository.findByEmailId(user.getEmailId()).isEmpty())
			{
				System.out.println( userRepository.findByEmailId(user.getEmailId()).toString());
				throw new Exception("User is already Registered with EmaildId");
			}
			else {
				User savedUser = userRepository.save(user);
			}
			
			
		} catch (Exception e) {
			throw new Exception("User is already Registered with EmaildId");
		}
		return userReg;
		
	}
	

}
