package com.ashwin.ukforum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.Comment;
import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.service.ArticleService;
import com.ashwin.ukforum.service.CommentService;
import com.ashwin.ukforum.service.UserService;

@Controller
public class CommentsController {
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/new-comment/article/{id}", method = RequestMethod.GET)
	public String newComment(@PathVariable("id") Long articleId)
	{
		Comment comment = new Comment();
		comment.setArticle(articleService.getArticle(articleId));		
		return "new-comment";
	}
	
	@RequestMapping(value = "/new-comment/article/{id}", method = RequestMethod.POST)
	public String addComment(ModelMap model, @Valid Comment comment, BindingResult result, @PathVariable("id") Long articleId) {
		
		if(result.hasErrors())
		{
			return "new-comment/article/" + articleId;
		}
		
		commentService.addComment(comment);
		
		List<Comment> comments = articleService.getArticle(articleId).getComments();
		comments.add(comment);
		
		return "redirect:article/" + articleId; // Go to the page to both Add and Edit Todos
	}
}
