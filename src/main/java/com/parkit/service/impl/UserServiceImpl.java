package com.parkit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parkit.entity.User;
import com.parkit.repository.UserRepository;
import com.parkit.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public boolean isUser(String username, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
		if (user == null)
		return false;
		
		else
			return user.getPassword().equals(password);
	}

}
