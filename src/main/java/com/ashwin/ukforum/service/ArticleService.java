package com.ashwin.ukforum.service;
import java.util.List;

import com.ashwin.ukforum.model.Article;

public interface ArticleService {
	
	// Get all Articles for the Articles' Index page (/articles)
	List<Article> findAll();
	
	// Get the 5 latest Articles for the Home Page (/)
	List<Article> findLatest5Articles();
	
	// Get all Articles of a particular User (/articles/user/{id}
	List<Article> findAllByUserId(Long userId);
	
	// Get a particular Article (/article/{id}
	Article findById(Long id);
	
	Article create(Article article);
	Article edit(Article article);
	void deleteById(Long id);

	//List<Comment> findAllCommentsForArticle(Long articleId);
}
