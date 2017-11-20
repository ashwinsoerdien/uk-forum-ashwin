package com.ashwin.ukforum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashwin.ukforum.dao.CommentDao;
import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.Comment;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	@Transactional
	public void addComment(Comment comment) {
		commentDao.addComment(comment);		
	}

	@Override
	@Transactional(readOnly=true)
	public Comment getComment(Long commentId) {
		return commentDao.getComment(commentId);
	}

	@Override
	@Transactional
	public Comment updateComment(Comment comment) {
		return commentDao.updateComment(comment);
	}

	@Override
	@Transactional
	public void deleteComment(Long commentId) {
		commentDao.deleteComment(commentId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Comment> getAllCommentsByArticleId(Long articleId) {
		return commentDao.getAllCommentsByArticleId(articleId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Comment> getAllCommentsByUserId(Long userId) {
		return commentDao.getAllCommentsByUserId(userId);
	}	
}