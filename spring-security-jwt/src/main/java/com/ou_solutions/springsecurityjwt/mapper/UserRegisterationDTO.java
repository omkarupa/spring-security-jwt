package com.ou_solutions.springsecurityjwt.mapper;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserRegisterationDTO(
		@NotEmpty String name,
		@NotEmpty @Email String emailId,
		@NotEmpty String password,
		@NotEmpty String role) {}
