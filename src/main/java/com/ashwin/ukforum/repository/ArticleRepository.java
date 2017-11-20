package com.ashwin.ukforum.repository;

import com.ashwin.ukforum.model.Article;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> 
{
	@Query("SELECT a FROM Article a LEFT JOIN FETCH a.user ORDER BY a.updated_at DESC")
    List<Article> findAllArticles(Pageable pageable);
}