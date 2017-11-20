package com.ashwin.ukforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ashwin.ukforum.model.LoginForm;
import com.ashwin.ukforum.service.UserService;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLogin()
	{
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String userLogin(ModelMap model, @ModelAttribute("loginForm") LoginForm loginForm)
	{		
//		if (!userService.loginUser(loginForm.getUsername(), loginForm.getPassword()))
//		{
//			System.out.println("cannot login");
//			return "login";			
//		}
//		
		System.out.println(loginForm.getUsername() + " " + loginForm.getPassword());
		
		return "redirect:/";
	}
}
