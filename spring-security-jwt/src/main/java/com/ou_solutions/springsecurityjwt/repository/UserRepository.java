package com.ou_solutions.springsecurityjwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ou_solutions.springsecurityjwt.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmailId(String emailId);

}
