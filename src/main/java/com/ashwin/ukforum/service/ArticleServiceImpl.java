package com.ashwin.ukforum.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.repository.ArticleRepository;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepo;

	private List<Article> articles = new ArrayList<Article>() {
		{
			add(new Article(1L, "First Post", "<p>Line #1.</p><p>Line #2</p>", null));
			add(new Article(2L, "Second Post", "Second post content:<ul><li>line 1</li><li>line 2</li></p></ul>",
					new User(10L, "ashwin", "ashwin")));
			add(new Article(3L, "Post #3", "<p>The post number 3 nice</p>", new User(10L, "phoebe", "phoebe")));
			add(new Article(4L, "Forth Post", "<p>Not interesting post</p>", null));
			add(new Article(5L, "Post Number 5", "<p>Just posting</p>", null));
			add(new Article(6L, "Sixth Post", "<p>Another interesting post</p>", null));
		}
	};

	@Override
	public List<Article> findAll() {
		return this.articleRepo.findAll();
	}
	
	@Override
	public List<Article> findLatest5Articles() {
		return this.articleRepo.findAll().stream().sorted((a, b) -> b.getUpdated_at().compareTo(a.getUpdated_at())).limit(5)
				.collect(Collectors.toList());
	}
	
//	@Override
//	public List<Article> findLatest5Articles() {
//		return this.articleRepo.findLatest5Articles(new PageRequest(0, 5));
//	}

//	@Override
//	public List<Article> findLatest5Articles() {
//		// TODO Auto-generated method stub
//		return this.articles.stream().sorted((a, b) -> b.getUpdated_at().compareTo(a.getUpdated_at())).limit(5)
//				.collect(Collectors.toList());
//	}

	@Override
	public List<Article> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		return this.articles.stream().filter(a -> Objects.equals(a.getUser().getId(), userId))
				.collect(Collectors.toList());
	}

	@Override
	public Article findById(Long id) {
		return this.articleRepo.findOne(id);
	}

	@Override
	public Article create(Article article) {
		return this.articleRepo.save(article);
	}

	@Override
	public Article edit(Article article) {
		return this.articleRepo.save(article);
	}

	@Override
	public void deleteById(Long id) {
		this.articleRepo.delete(id);
	}
}