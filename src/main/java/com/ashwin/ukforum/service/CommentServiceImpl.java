package com.ashwin.ukforum.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.Comment;
import com.ashwin.ukforum.repository.CommentRepository;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CommentRepository commentRepo;
	
	@Override
	public Comment getComment(Long id) 
	{
		return commentRepo.findOne(id);		
	}

	@Override
	public Long saveNewComment(Comment comment, Article article) {
		comment.setCreated_at(new Date());
		comment.setArticle(article);
		comment.setUser(userService.currentUser());
		commentRepo.saveAndFlush(comment);
		
		return comment.getId();
	}

	@Override
	public void deleteComment(Long commentId) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void updateComment(Comment newComment, Long commentId) {
		// TODO Auto-generated method stub		
	}
	
}