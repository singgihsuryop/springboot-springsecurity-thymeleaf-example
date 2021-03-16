package com.singgihsuryop.springboot.springsecurity.httpbasic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Configuration
public class CustomLogoutHandler implements LogoutHandler{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomLogoutHandler.class);
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		System.err.println("LOGOUT HANDLER");
		if(authentication != null)
			new SecurityContextLogoutHandler().logout(request, response, authentication);
	}
}
