package com.ashwin.ukforum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ashwin.ukforum.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String newUser()
	{
		return "newUser";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser()
	{
		return "user";
		
	}
}
