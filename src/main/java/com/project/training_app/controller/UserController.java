package com.project.training_app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.training_app.service.UserService;
import com.project.training_app.to.UserTo;



@Controller
public class UserController {

	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users.htm")
	public String getAllUsers(Model model) {
		
		List<UserTo> userList = null;
		userList = userService.getAllUsers();
		
		model.addAttribute("users", userList);
		
		return "user/users";
	}
	
	
	
	@GetMapping("/createUser.htm")
	public String createUser(Model model) {
		
		
		model.addAttribute("user", new UserTo());
		
		return "user/createUser";
		
	}
	
	@PostMapping("/saveUser.htm")
	public String saveUserr(Model model , @ModelAttribute UserTo userTo) {
		
		userService.saveUser(userTo);
		return "redirect:/users.htm";
	}
	
	@GetMapping("/deleteUser.htm/{id}")
	public String deleteuser(@PathVariable int id ) {
		
		userService.removeUser(id);
		
		return "redirect:/users.htm";
	}
	
	
	@GetMapping("/updateUser.htm/{id}")
	public String updateUser( Model model,@PathVariable int id ) {
		
		UserTo userTo = userService.getUserById(id);
		
		model.addAttribute("user", userTo);
		
		return "user/updateUser";
		
	}
	
	
	@PostMapping("/saveUserChanges.htm")
	public String saveUserChanges(@ModelAttribute UserTo userTo ) {
		
		userService.updateUser(userTo);
		
		return "redirect:/users.htm";
		
	}
	

	
	}
