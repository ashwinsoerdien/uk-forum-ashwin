package com.ashwin.ukforum.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.ukforum.dao.ArticleDao;
import com.ashwin.ukforum.model.Article;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleDao articleDao;

	@Override
	@Transactional(readOnly=true)
	public List<Article> getLatest5Articles() {
		return articleDao.getLatest5Articles();
	}

	@Override
	@Transactional(readOnly=true)
	public Article getArticle(Long articleId) {
		return articleDao.getArticle(articleId);
	}

	@Override
	@Transactional
	public void deleteArticle(Long articleId) {
		articleDao.deleteById(articleId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Article> getAllArticles() {
		return articleDao.getAllArticles();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Article> getAllArticlesByUserId(Long userId) {
		return articleDao.getAllArticlesByUserId(userId);
	}

	@Override
	@Transactional
	public void addArticle(Article article, Long userId) {
		articleDao.addArticle(article, userId);
	}

	@Override
	@Transactional
	public Article updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public List<Article> getApprovedArticlesByUserId(Long userId) {
		return articleDao.getApprovedArticlesByUserId(userId);
	}

	@Override
	public List<Article> getPendingArticlesByUserId(Long userId) {
		return articleDao.getPendingArticlesByUserId(userId);
	}

	
}