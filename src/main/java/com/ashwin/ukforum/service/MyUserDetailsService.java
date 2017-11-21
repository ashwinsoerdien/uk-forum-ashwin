package com.ashwin.ukforum.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashwin.ukforum.dao.UserDao;
import com.ashwin.ukforum.model.UserRole;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    		com.ashwin.ukforum.model.User user = userDao.findByUserName(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (UserRole role : user.getUserRole()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
