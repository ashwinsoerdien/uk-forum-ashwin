package com.ashwin.ukforum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;

	@Override
	public User findUserByUsername(String username) {
		return userRepo.findByUsernameIgnoreCase(username);
	}

	@Override
	public User findById(Long id) {
		return userRepo.findOne(id);
	}
	
	@Override
	public void registerUser(User user) {
		user.setPasswordHash(user.getPasswordHash());
		user.setAdmin(false);
		userRepo.saveAndFlush(user);
	}
	
	@Override
	public void loginUser(User user) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public boolean isLoggedInUser() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean isAdmin() {
		User user = currentUser();		
		return user.isAdmin();
	}

	@Override
	public User currentUser() {
		return userRepo.findByUsernameIgnoreCase("ashwin");
	}
}