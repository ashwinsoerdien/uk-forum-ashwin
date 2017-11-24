package com.ashwin.ukforum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.ashwin.ukforum.model.Article;
import com.ashwin.ukforum.service.ArticleService;


@Controller
public class CSVFileController
{
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/downloadCSV")
	public void downloadCSV(HttpServletResponse response) throws IOException
	{
		String csvFilename = "articles.csv";
		 
        response.setContentType("text/csv");
        
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", csvFilename);
        response.setHeader(headerKey, headerValue);
        
        List<Article> allArticles = articleService.getAllArticles();
 
        // The Super CSV API generates the CSV file from the list
        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "id", "title", "content"};
 
        csvWriter.writeHeader(header);
 
        for (Article article : allArticles) {
            csvWriter.write(article, header);	
        }
 
        csvWriter.close();
		
	}
}
