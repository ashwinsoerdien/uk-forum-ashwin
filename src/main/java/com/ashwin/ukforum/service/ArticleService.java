package com.ashwin.ukforum.service;
import java.util.List;
import java.util.Optional;
import com.ashwin.ukforum.model.Comment;
import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.model.Article;

public interface ArticleService {
	
	// Get the 5 latest Articles for the Home Page (/)
	List<Article> getLatest5Articles();
	
    // Get a particular Article (/article/{id}
    public Article getArticle(Long articleId);
    
    public void deleteArticle(Long articleId);
	// Get all Articles for the Articles' Index page (/articles)
    public List<Article> getAllArticles();
    
    // Get all Articles of a particular User (/articles/user/{id}
    List<Article> getAllArticlesByUserId(Long userId);
    
    // Get all Approved Articles of a particular User (/articles/user/{id}
 	List<Article> getApprovedArticlesByUserId(Long userId);
 		
	// Get all Pending Articles of a particular User (/articles/user/{id}
	List<Article> getPendingArticlesByUserId(Long userId);
    
    public void addArticle(Article article, Long userId);
    public Article updateArticle(Article article);
    
}
