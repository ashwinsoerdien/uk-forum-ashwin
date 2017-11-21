package com.ashwin.ukforum.dao;

import java.util.List;
import com.ashwin.ukforum.model.User;
 
public interface UserDao {
 
	// CREATE User
    public void addUser(User user);
    
    // READ User
    public User getUser(Long userId);
 
    // UPDATE User
    public User updateUser(User user);
    
    // DELETE User
    public void deleteUser(Long userId);
    
    // LIST Users
    public List<User> getAllUsers();
    
    public Long getUserId(String username);
    
    public User findByUserName(String username);
}