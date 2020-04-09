package com.kiran.test4.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kiran.test4.models.User;
import com.kiran.test4.repositories.UserRepository;

import javassist.expr.NewArray;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping({"/","/login"})
	public ModelAndView index() {
		return new ModelAndView("login");
	}
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");
	}
	
	@GetMapping("/home")
	public ModelAndView home(User user) {
		return new ModelAndView("home", "user", user);
	}
	
	@PostMapping("/processLogin")
	public ModelAndView processLogin(@ModelAttribute User user) {
		if(userRepository.authenticate(user)) {
			return new ModelAndView("redirect:/home","user",user);
		}
		return new ModelAndView("redirect:/login");
	}
	
	@PostMapping("/processRegister")
	public ModelAndView processRegister(@ModelAttribute User user) {
		userRepository.insert(user);
		return new ModelAndView("redirect:/login");
	}
	
	@GetMapping("/delete/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.delete(id);
	}
}
