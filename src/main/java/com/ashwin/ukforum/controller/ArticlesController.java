package com.ashwin.ukforum.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	// Get the current logged-in User for use in writing and retrieving articles
	private Long retrieveLoggedInUserId() {
		Long result = userService.getUserId(retrieveLoggedInUsername());

		if (result != null)
			return result;
		else
			return 0L;
	}

	private String retrieveLoggedInUsername() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}

		System.out.println("Retrieved user name: " + userName);
		return userName;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		List<Article> latest5Articles = articleService.getLatest5Articles();
		model.addAttribute("title", "Latest Articles");
		model.addAttribute("allArticles", latest5Articles);

		return "index";
	}

	@RequestMapping(value = "/newarticle", method = RequestMethod.GET)
	public String newArticle(ModelMap model) {

		Article article = new Article();
		article.setUser(userService.getUser(retrieveLoggedInUserId()));

		model.addAttribute("article", article);
		model.addAttribute("title", "Write a new Article");

		return "newarticle";
	}

	@RequestMapping(value = "/newarticle", method = RequestMethod.POST)
	public String saveOrUpdateArticle(@ModelAttribute("article") Article article, BindingResult result,
			ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("Errors in validating the article");
			return "newarticle";
		}

		User user = userService.getUser(retrieveLoggedInUserId());
		article.setUser(user);

		articleService.addArticle(article);
		model.clear();
		return "redirect:myarticles";
	}

	@RequestMapping(value = "/articles", method = RequestMethod.GET)
	public String articlesIndex(ModelMap model) {
		List<Article> allArticles = articleService.getAllArticles();

		model.addAttribute("title", "All Articles");
		model.addAttribute("allArticles", allArticles);

		return "articles";
	}

	@RequestMapping(value = "/myarticles", method = RequestMethod.GET)
	public String showArticlesByUser(ModelMap model) {
		List<Article> myArticles = articleService.getAllArticlesByUserId(retrieveLoggedInUserId());

		model.addAttribute("username", retrieveLoggedInUsername());
		model.addAttribute("title", "My Articles");
		model.addAttribute("myArticles", myArticles);

		return "myarticles";
	}

	@RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
	public String showArticle(ModelMap model, @PathVariable("id") Long id) {
		Article article = articleService.getArticle(id);
		model.addAttribute("title", "Latest Articles");
		model.addAttribute("article", article);
		return "article";
	}

	// @RequestMapping(value = "/search", method = RequestMethod.POST)
	// public String articlesByKeyword(ModelMap model, @RequestParam("keyword")
	// String keyword)
	// {
	// System.out.println("Keywords: " + keyword);
	//
	// List<Article> allArticles =
	// articleService.getMatchingArticlesByKeyword(keyword);
	// model.addAttribute("title", "Search Articles");
	// model.addAttribute("allArticles", allArticles);
	// return "articles";
	// }

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("keyword") String keyword, ModelMap model) throws Exception {
		
		System.out.println("Search results...");
		
		List<Article> allArticles = articleService.getMatchingArticlesByKeyword(keyword);

		model.addAttribute("allArticles", allArticles);
		return "articles";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model) {
		List<Article> allArticles = articleService.getAllArticles();
		model.addAttribute("title", "Manage Articles");
		model.addAttribute("allArticles", allArticles);
		return "admin";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", retrieveLoggedInUsername());
		return "accessDenied";
	}

	// When deleting an Article, do not go to a different page, stay on the same
	// page with the list of Articles
	@RequestMapping(value = "/deletearticle", method = RequestMethod.GET)
	public String deleteArticle(ModelMap model, @RequestParam Long id) {
		articleService.deleteArticle(id);
		model.clear(); // clear the model since you do not want to pass any variables when redirecting
		return "redirect:myarticles"; // Go back to My Articles
	}

	@RequestMapping(value = "/editarticle", method = RequestMethod.GET)
	public String editArticle(ModelMap model, @RequestParam Long id) {
		Article article = articleService.getArticle(id);
		model.addAttribute("title", "Edit Article");
		model.addAttribute("article", article);
		return "editarticle";
	}

	@RequestMapping(value = "/editarticle", method = RequestMethod.POST)
	public String updateArticle(@ModelAttribute("article") Article article, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("Errors in validating the article");
			return "redirect:editarticle/" + article.getId();
		}

		User user = userService.getUser(retrieveLoggedInUserId());
		article.setUser(user);

		articleService.updateArticle(article);
		model.clear();
		return "redirect:articles";
	}

	// When approving an Article, do not go to a different page, stay on the same
	// page with the list of Articles
	@RequestMapping(value = "/approveArticle/{id}", method = RequestMethod.GET)
	public String approveArticle(ModelMap model, @PathVariable("id") Long id) {
		Article article = articleService.getArticle(id);
		articleService.approveArticle(article, true);
		model.clear();
		return "redirect:admin";
	}

	@RequestMapping(value = "/rejectArticle/{id}", method = RequestMethod.GET)
	public String rejectArticle(ModelMap model, @PathVariable("id") Long id) {
		Article article = articleService.getArticle(id);
		articleService.approveArticle(article, false);
		model.clear();
		return "redirect:admin";
	}
}
