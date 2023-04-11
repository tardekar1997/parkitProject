package com.parkit.service;

import com.parkit.entity.User;

public interface UserService {

	User addUser(User user);
	boolean isUser(String username, String password);
}
