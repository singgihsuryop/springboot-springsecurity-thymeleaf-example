package com.singgihsuryop.springboot.springsecurity.httpbasic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user1").password("userpassword1").roles("USER")
			.and()
			.withUser("admin1").password("adminpassword1").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
				.formLogin().defaultSuccessUrl("/")
			.and()
				.logout()
				.logoutUrl("/logout-now")
				.addLogoutHandler(customLogoutHandler())
				.permitAll()
			.and()
				.httpBasic();
	}
	
	@Bean(name="customLogoutHandler")
	public CustomLogoutHandler customLogoutHandler() {
		return new CustomLogoutHandler();
	}
	
}
