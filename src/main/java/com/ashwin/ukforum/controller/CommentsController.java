package com.ashwin.ukforum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	// Get the current logged-in User Id for use in writing and retrieving articles
	private Long retrieveLoggedInUserId() {
		Long result = 0L;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails)
			result = userService.getUserId(((UserDetails) principal).getUsername());

		result = userService.getUserId(principal.toString());
		
		System.out.println("User id logged in: ");

		return result;
	}
	
	@RequestMapping(value = "/newcomment/article/{articleId}", method = RequestMethod.GET)
	public String showNewComment(ModelMap model, @PathVariable("articleId") Long articleId) 
	{
		Comment comment = new Comment();	
		Article article = articleService.getArticle(articleId);
		comment.setArticle(article);	
		comment.setUser(article.getUser());
		comment.setContent("");
		model.addAttribute("comment", comment);		
		model.addAttribute("title", "Add Comment");
		
		return "newcomment";
	}
	
    @RequestMapping(value = "/newcomment/article/{articleId}", method = RequestMethod.POST)
    public String addComment(@ModelAttribute("comment") Comment comment, BindingResult result, ModelMap model, @PathVariable("articleId") Long articleId) 
    {    	
        if (result.hasErrors()) 
        {
			System.out.println("Errors in validating the article");
			return "redirect:newcomment/article/" + articleId;
		}

        Article article = articleService.getArticle(articleId);
        
        comment.setArticle(article);
        
        comment.setUser(article.getUser());
        
        System.out.println("Comment: " + comment.toString());
        
        commentService.addComment(comment);
        
        model.addAttribute("article", article);

        return "redirect:/article/" + articleId;
    }
}
