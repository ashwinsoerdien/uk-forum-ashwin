package com.ashwin.ukforum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.service.ArticleService;

@Controller
public class ArticlesController {
	
	@Autowired
	private ArticleService articleService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String articlesIndex(ModelMap model)
	{
		model.addAttribute("title", "Latest Articles");
		
		List<Article> allArticles = articleService.findAll();
		model.addAttribute("allArticles", allArticles);
		return "articles";
	}
	
	@RequestMapping(value = "/article/{id}")
	public String showArticle(@PathVariable("id") Long id, ModelMap model)
	{
		Article article = articleService.findById(id);
		
		model.addAttribute("title", article.getTitle());
		
		model.addAttribute("article", article);
		
		return "article";		
	}
}
