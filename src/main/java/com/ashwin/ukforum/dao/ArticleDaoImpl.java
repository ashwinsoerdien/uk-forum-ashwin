package com.ashwin.ukforum.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ashwin.ukforum.model.Article;
 
@Repository
public class ArticleDaoImpl implements ArticleDao {
 
    @Autowired
    private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM Article a ORDER BY a.updated_at DESC").list();
	}

	@Override
	public List<Article> getLatest5Articles() {
		return sessionFactory.getCurrentSession().createQuery("TOP 5 FROM Article a ORDER BY a.updated_at DESC").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticlesByUserId(Long userId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Article a WHERE a.user_id = :user_id");
		query.setParameter("user_id", userId);
		return query.getResultList();
	}

	@Override
	public Article getArticle(Long articleId) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, articleId);
	}

	@Override
	public void addArticle(Article article) {
		sessionFactory.getCurrentSession().saveOrUpdate(article);		
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
 
}