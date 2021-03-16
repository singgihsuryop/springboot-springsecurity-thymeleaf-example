package com.singgihsuryop.springboot.springsecurity.httpbasic.web;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	private Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index(Principal principal, Model model) throws Exception{
		System.err.println("enter home page");
		System.err.println(SecurityContextHolder.getContext().getAuthentication().toString())		;
		model.addAttribute("title", "Spring Security Custom Login Form");
		model.addAttribute("message", "Hello, " +principal.getName()+". This is welcome page!");
		return "index";
	}
}
