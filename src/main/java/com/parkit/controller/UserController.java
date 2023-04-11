package com.parkit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parkit.entity.User;
import com.parkit.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<User> Uregister(@RequestBody User user){
		User newUser= userService.addUser(user);
		System.out.println("\n user added succuessfully.. \n");
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> Ulogin(@RequestBody User user)
	{
		if(userService.isUser(user.getUsername(), user.getPassword())) {
			return new ResponseEntity<>("login successful", HttpStatus.OK);
			}
		else 
			return new ResponseEntity<>("invalid credentials", HttpStatus.UNAUTHORIZED);
		
		
	}
	
}
