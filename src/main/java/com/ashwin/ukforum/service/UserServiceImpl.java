package com.ashwin.ukforum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.ashwin.ukforum.dao.UserDao;
import com.ashwin.ukforum.model.User;
 
@Service
@Transactional
public class UserServiceImpl implements UserService {
 
    @Autowired
    private UserDao userDao;
 
    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
 
    @Override
    @Transactional(readOnly=true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
 
    @Override
    @Transactional
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }
 
    @Override
    @Transactional(readOnly=true)
    public User getUser(Long userId) {
        return userDao.getUser(userId);
    }
 
    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

	@Override
	public Long getUserId(String username) {
		return userDao.getUserId(username);
	} 
}