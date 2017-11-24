package com.ashwin.ukforum.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.Comment;
 
@Repository
public class ArticleDaoImpl implements ArticleDao {
 
    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		return sessionFactory.getCurrentSession().createQuery("FROM Article a ORDER BY a.updated_at DESC").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getLatest5Articles() {
		return sessionFactory.getCurrentSession().createQuery("FROM Article a ORDER BY a.updated_at DESC").setMaxResults(5).list();
	}	

	@Override
	public Article getArticle(Long articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@Override
	public Article updateArticle(Article article) {
		sessionFactory.getCurrentSession().update(article);
        return article;
	}

	@Override
	public void deleteById(Long articleId) {
		Article article = (Article) sessionFactory.getCurrentSession().load(Article.class, articleId);
        if (null != article) {
            this.sessionFactory.getCurrentSession().delete(article);
        }
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticlesByUserId(Long userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.user.id = :user_id");
		query.setParameter("user_id", userId);		
		List<Article> results = query.getResultList();		
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getApprovedArticlesByUserId(Long userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.user.id = :user_id AND a.approved='1'");
		query.setParameter("user_id", userId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getPendingArticlesByUserId(Long userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.user.id = :user_id AND a.approved='0'");
		query.setParameter("user_id", userId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getMatchingArticlesByKeyword(String keyword) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.content LIKE :keywords");
		query.setParameter("keywords", "%" + keyword + "%");
		return query.getResultList();
	}

	@Override
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().saveOrUpdate(article);		
	}

	@Override
	public void approveArticle(Article article, boolean status) {
		
		String statusValue = status ? "1" : "0";
		
		Query query = sessionFactory.getCurrentSession().createQuery("UPDATE Article a set a.approved = '" + statusValue + "' WHERE a.id = :article_id");
		query.setParameter("article_id", article.getId());
		query.executeUpdate();	
	} 
}