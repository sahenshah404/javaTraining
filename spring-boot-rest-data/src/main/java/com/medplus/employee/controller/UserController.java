package com.medplus.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medplus.employee.dto.UserDetailsDto;
import com.medplus.employee.dto.UserLoginDto;
import com.medplus.employee.entities.Users;
import com.medplus.employee.service.UsersService;

@CrossOrigin(origins = {"http://localhost:3000"})
@RestController
@RequestMapping("/")
public class UserController {
	@Autowired
	UsersService usersService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDetailsDto> login(@RequestBody UserLoginDto userLoginDto){
		UserDetailsDto userDetails =  usersService.login(userLoginDto);
		return new ResponseEntity<UserDetailsDto>(userDetails,HttpStatus.OK);
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<String> addUser(@RequestBody Users user){
	
		usersService.addUser(user);
		return new ResponseEntity<String>("User Added",HttpStatus.OK);
	}

}
