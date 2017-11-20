package com.ashwin.ukforum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.service.UserService;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "users";
	}

	@RequestMapping(value = "/new-user", method = RequestMethod.GET)
	public String newUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);

		return "new-user";
	}

	@RequestMapping(value = "/save-user", method = RequestMethod.POST)
	public String saveUser(ModelMap model, @Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "new-user";
		} else {

			if (user.getId() == 0)
				userService.addUser(user);
			else
				userService.updateUser(user);

			model.clear();
			return "redirect:users";
		}
	}

	@RequestMapping(value = "/delete-user", method = RequestMethod.GET)
	public String deleteUser(ModelMap model, @RequestParam Long id) {
		Long userId = id;
		userService.deleteUser(userId);
		return "redirect:users";
	}

	@RequestMapping(value = "/edit-user", method = RequestMethod.POST)
	public String editUser(ModelMap model, @Valid User user, BindingResult result) {
		
		if(result.hasErrors())
		{
			return "user";
		}
		
		userService.updateUser(user);	
		model.clear();;
		return "users";
	}
}
