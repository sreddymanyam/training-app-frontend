package com.project.training_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("home.htm")
	public String homeController() {
		
		return "home";
	}
	
	
	@GetMapping("support.htm")
	public String supportController() {
		
		return "support";
	}
}
