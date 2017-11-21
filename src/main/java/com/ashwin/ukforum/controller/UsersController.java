package com.ashwin.ukforum.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwin.ukforum.model.User;
import com.ashwin.ukforum.service.UserService;
import com.ashwin.ukforum.validator.UserValidator;

@Controller
public class UsersController {

	@Autowired
	private UserService userService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

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

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(ModelMap model, @Valid User user, BindingResult result) {
		if(result.hasErrors())
		{
			return "new-user";
		}
		
		System.out.println("user id: " + user.getId());
		
		userService.addUser(user);
		model.addAttribute("user", user);
		return "redirect:user/{user.id}";
	}
	
	@RequestMapping(value = "/new-user", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, ModelMap model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(user);

        securityService.autologin(user.getUsername(), user.getPassword());

        return "redirect:/";
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
		model.clear();
		return "users";
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public String showUser(ModelMap model, @PathVariable("id") Long id) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "user";
	}
}