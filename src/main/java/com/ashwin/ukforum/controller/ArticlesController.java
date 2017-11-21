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
import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.service.ArticleService;
import com.ashwin.ukforum.service.UserService;

@Controller
public class ArticlesController {
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private UserService userService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String articlesIndex(ModelMap model)
	{
		model.addAttribute("title", "Latest Articles");
		
		List<Article> allArticles = articleService.getAllArticles();
		model.addAttribute("allArticles", allArticles);
		
		return "index";
	}
	
	@RequestMapping(value = "/article/{id}")
	public String showArticle(@PathVariable("id") Long id, ModelMap model)
	{
		Article article = articleService.getArticle(id);
		
		model.addAttribute("title", article.getTitle());
		
		model.addAttribute("article", article);
		
		return "article";		
	}
	
	@RequestMapping(value = "/new-article", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "new-article";
	}
	
	@RequestMapping(value = "/delete-article", method = RequestMethod.GET)
	public String deleteTodo(ModelMap model, @RequestParam Long id) {
		articleService.deleteArticle(id);
		model.clear(); // clear the model since you do not want to pass any variables when redirecting
		return "redirect:articles"; // Go to the page to both Add and Edit Todos
	}
	
	private Long retrieveLoggedInUserId()
	{
		Long result = 0L;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails)
			result = userService.getUserId(((UserDetails) principal).getUsername());
		
		result = userService.getUserId(principal.toString());

		return result;
	}
}
