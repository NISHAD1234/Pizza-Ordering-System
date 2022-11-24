package com.crud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeControllers {
	
	public WelcomeControllers() {
		System.out.println("\n\n==Welcom Controller Initialized==\n\n");
	}
	@RequestMapping("/welcome")
	public String welcomePage() {
		return "index.jsp";
	}
	
	@RequestMapping("/hello")
	public String helloPage() {
		return "hello.jsp";
	}
  
}
