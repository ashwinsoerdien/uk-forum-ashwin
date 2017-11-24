package com.ashwin.ukforum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.ashwin.ukforum.model.User;
 
@Repository
public class UserDaoImpl implements UserDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addUser(User user) {
    	
        sessionFactory.getCurrentSession().saveOrUpdate(user); 
    }
 
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() { 
        return sessionFactory.getCurrentSession().createQuery("FROM User u ORDER BY u.created_at DESC").list();
    }
 
    @Override
    public void deleteUser(Long userId) {
        User user = (User) sessionFactory.getCurrentSession().load(User.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }
 
    public User getUser(Long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }
 
    @Override
    public User updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

	@SuppressWarnings("unchecked")
	@Override
	public Long getUserId(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("SELECT u.id FROM User u WHERE u.username = :username");
		query.setParameter("username", username);
		List<Long> results = query.getResultList();		
		return results.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
    
 
}