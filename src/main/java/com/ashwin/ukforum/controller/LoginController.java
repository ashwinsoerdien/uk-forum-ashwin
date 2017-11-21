package com.ashwin.ukforum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwin.ukforum.model.LoginForm;
//import com.ashwin.ukforum.service.UserService;


@Controller
public class LoginController
{		
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin()
	{ 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) {
			// The User is already logged in
			return "index";
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(ModelMap model, @ModelAttribute("loginForm") LoginForm loginForm)
	{
		System.out.println(loginForm.getUsername() + " " + loginForm.getPassword());
		
		return "redirect:user";
	}
}
