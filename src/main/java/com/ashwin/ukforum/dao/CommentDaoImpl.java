package com.ashwin.ukforum.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashwin.ukforum.model.Comment;
import com.ashwin.ukforum.model.User;
 
@Repository
public class CommentDaoImpl implements CommentDao {
 
    @Autowired
    private SessionFactory sessionFactory;

	@Override
	public void addComment(Comment comment) {
		sessionFactory.getCurrentSession().saveOrUpdate(comment);		
	}

	@Override
	public Comment getComment(Long commentId) {
		return (Comment) sessionFactory.getCurrentSession().get(Comment.class, commentId);
	}

	@Override
	public Comment updateComment(Comment comment) {
        sessionFactory.getCurrentSession().update(comment);
        return comment;
	}

	@Override
	public void deleteComment(Long commentId) {
		Comment comment = (Comment) sessionFactory.getCurrentSession().load(Comment.class, commentId);
        if (null != comment) {
            this.sessionFactory.getCurrentSession().delete(comment);
        }
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentsByArticleId(Long articleId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment c WHERE c.article_id = :article_id");
		query.setParameter("article_id", articleId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllCommentsByUserId(Long userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Comment c WHERE c.user_id = :user_id");
		query.setParameter("user_id", userId);
		return query.getResultList();
	}
 
    
 
}