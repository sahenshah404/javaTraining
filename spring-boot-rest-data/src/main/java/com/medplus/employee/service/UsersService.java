package com.medplus.employee.service;

import com.medplus.employee.dto.UserDetailsDto;
import com.medplus.employee.dto.UserLoginDto;
import com.medplus.employee.entities.Users;

public interface UsersService {
	
	Users getUsersById (String userid);

	UserDetailsDto login(UserLoginDto userLoginDto);

	void addUser(Users user);

}
