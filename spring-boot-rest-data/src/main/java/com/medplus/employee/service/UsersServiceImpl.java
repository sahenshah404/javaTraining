package com.medplus.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medplus.employee.dao.UsersDao;
import com.medplus.employee.dto.UserDetailsDto;
import com.medplus.employee.dto.UserLoginDto;
import com.medplus.employee.entities.Users;
import com.medplus.employee.exceptions.IncorrectPasswordException;
import com.medplus.employee.exceptions.UserNotFoundException;
import com.medplus.employee.exceptions.UserNotCreatedException;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	UsersDao usersDao;

	@Override
	public Users getUsersById(String userid) {
		// TODO Auto-generated method stub
		Optional<Users> user = usersDao.findById(userid);
		if(!user.isPresent()){
			throw new UserNotFoundException();
		}
		else {
			return user.get();			
		}
	}

	@Override
	public UserDetailsDto login(UserLoginDto userLoginDto) {
		
		Users user = getUsersById(userLoginDto.getUserid());
		if(user.getPassword().equals(userLoginDto.getPassword())) {
			UserDetailsDto userDetails = new UserDetailsDto();
			userDetails.setUserid(user.getUserid());
			userDetails.setRole(user.getRole());
			return userDetails;
		}else {
			throw new IncorrectPasswordException();
		}
		
	}

	@Override
	public void addUser(Users user) {		
		Users res = usersDao.save(user);
		if(res==null){
			throw new UserNotCreatedException();
		}
		
	}

}
