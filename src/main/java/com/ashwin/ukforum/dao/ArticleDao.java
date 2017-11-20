package com.ashwin.ukforum.dao;

import java.util.List;
import java.util.Optional;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.User;
 
public interface ArticleDao 
{
		// Get all Articles for the Articles' Index page (/articles)
		List<Article> getAllArticles();
		
		// Get the 5 latest Articles for the Home Page (/)
		List<Article> getLatest5Articles();
		
		// Get all Articles of a particular User (/articles/user/{id}
		List<Article> getAllArticlesByUserId(Long userId);
		
		// Get a particular Article (/article/{id}
		Article getArticle(Long articleId);
		
		void addArticle(Article article);
		
		Article updateArticle(Article article);
		
		void deleteById(Long articleId);  
}