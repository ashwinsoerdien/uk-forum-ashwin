package com.ashwin.ukforum.service;

import com.ashwin.ukforum.model.User;

public interface UserService {
	
	// Get a particular User (/user/{id}
	User findById(Long id);
	
	User findUserByUsername(String username);
	
	void registerUser(User user);
	
	void loginUser(User user);
	
	boolean isLoggedInUser();
	
	boolean isAdmin();
	
	User currentUser();
}
